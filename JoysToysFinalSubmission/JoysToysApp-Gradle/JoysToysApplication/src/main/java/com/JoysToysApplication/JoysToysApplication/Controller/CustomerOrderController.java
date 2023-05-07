package com.JoysToysApplication.JoysToysApplication.Controller;

import com.JoysToysApplication.JoysToysApplication.DTO.CustomerOrderDTO;
import com.JoysToysApplication.JoysToysApplication.DTO.ProductWithQuantity;
import com.JoysToysApplication.JoysToysApplication.DTO.ReceiptDTO;
import com.JoysToysApplication.JoysToysApplication.Entity.*;
import com.JoysToysApplication.JoysToysApplication.Repository.CustomerOrderRepository;
import com.JoysToysApplication.JoysToysApplication.Repository.CustomerRepository;
import com.JoysToysApplication.JoysToysApplication.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class CustomerOrderController {

    @Autowired
    CustomerOrderRepository customerOrderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductsRepository productsRepository;


    @GetMapping("/customer_order/{id}")
    public ResponseEntity<CustomerOrder> getCustomerOrder(@PathVariable("id") long id) {

        Optional<CustomerOrder> customerOrder = customerOrderRepository.findById(id);

        return customerOrder.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    private BigDecimal calculateTotal(Map<Long, Integer> order){
        BigDecimal total = BigDecimal.ZERO;
        for(Map.Entry<Long, Integer> entry : order.entrySet()){
            Optional<Products> product = productsRepository.findById(entry.getKey());
            if(product.isEmpty()){
                throw new IllegalArgumentException(entry.getKey() + " is not a valid product.");
            }

            total = total.add(product.get().getPrice().multiply(BigDecimal.valueOf(entry.getValue())));
        }
        return total;
    }

    //put is used when you change an existing resource. Post is used to create a new one, according to RESTful conventions
    @PostMapping("/customer_order")
    public ResponseEntity<ReceiptDTO> createCustomerOrder(@RequestBody CustomerOrderDTO customerOrderDTO){
        CustomerOrder customerOrder = new CustomerOrder();



        if(customerOrderDTO.getOrder().isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        /*
        what the code below is:
        customerRepository.findById(customerOrderDTO.getCustomer_id()).ifPresent(customer -> {
        customerOrder.setCustomer(customer);
        });
         */
        customerRepository.findById(customerOrderDTO.getCustomer_id()).ifPresent(customerOrder::setCustomer);

        for(Map.Entry<Long, Integer> entry : customerOrderDTO.getOrder().entrySet()){
            CustomerOrderProductAssociation customerOrderProductAssociation = new CustomerOrderProductAssociation();

            customerOrderProductAssociation.setQuantity(entry.getValue());


            productsRepository.findById(entry.getKey()).ifPresent(customerOrderProductAssociation::setProducts);

            customerOrderProductAssociation.setCustomer_order(customerOrder);

            customerOrder.addAssociation(customerOrderProductAssociation);
        }

        customerOrder.setCustomer_order_date(new Timestamp(System.currentTimeMillis()));


        customerOrder = customerOrderRepository.save(customerOrder);

        BigDecimal price = calculateTotal(customerOrderDTO.getOrder());
        customerOrder.setCustomerTransaction(new CustomerTransaction(price, customerOrderDTO.getPayment_information_id(), customerOrder));

        customerOrder = customerOrderRepository.save(customerOrder);

        List<ProductWithQuantity> productList = new ArrayList<>();
        for (Map.Entry<Long, Integer> entry : customerOrderDTO.getOrder().entrySet()) {
            Long productId = entry.getKey();
            Integer quantity = entry.getValue();
            Optional<Products> product = productsRepository.findById(productId); // fetch the product from the database
            productList.add(new ProductWithQuantity(product.get(), quantity)); // create a new ProductWithQuantity object and add it to the list
        }

        ReceiptDTO receipt = new ReceiptDTO(
                customerOrder.getCustomerTransaction().getCustomer_transaction_id(),
                customerOrder.getCustomer_id(),
                customerOrder.getCustomerTransaction().getAmount_paid()
                ,productList,
                customerOrder.getCustomer_order_date());

        return ResponseEntity.status(HttpStatus.CREATED).body(receipt);
    }




}

