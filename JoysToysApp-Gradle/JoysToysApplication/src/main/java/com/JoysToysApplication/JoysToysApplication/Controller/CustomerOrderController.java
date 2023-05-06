package com.JoysToysApplication.JoysToysApplication.Controller;

import com.JoysToysApplication.JoysToysApplication.DTO.CustomerOrderDTO;
import com.JoysToysApplication.JoysToysApplication.Entity.Customer;
import com.JoysToysApplication.JoysToysApplication.Entity.CustomerOrder;
import com.JoysToysApplication.JoysToysApplication.Entity.CustomerOrderProductAssociation;
import com.JoysToysApplication.JoysToysApplication.Entity.Products;
import com.JoysToysApplication.JoysToysApplication.Repository.CustomerOrderRepository;
import com.JoysToysApplication.JoysToysApplication.Repository.CustomerRepository;
import com.JoysToysApplication.JoysToysApplication.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
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

    //put is used when you change an existing resource. Post is used to create a new one, according to RESTful conventions
    @PostMapping("/customer_order")
    public ResponseEntity<CustomerOrder> createCustomerOrder(@RequestBody CustomerOrderDTO customerOrderDTO){
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


        return ResponseEntity.status(HttpStatus.CREATED).body(customerOrder);
    }




}

