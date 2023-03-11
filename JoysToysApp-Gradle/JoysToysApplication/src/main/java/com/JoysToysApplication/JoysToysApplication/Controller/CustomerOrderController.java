package com.JoysToysApplication.JoysToysApplication.Controller;

import com.JoysToysApplication.JoysToysApplication.Entity.CustomerOrder;
import com.JoysToysApplication.JoysToysApplication.Entity.Products;
import com.JoysToysApplication.JoysToysApplication.Repository.CustomerOrderRepository;
import com.JoysToysApplication.JoysToysApplication.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CustomerOrderController {

    @Autowired CustomerOrderRepository customerOrderRepository;

    //NOT GOOD TO HAVE PRODUCT REPOSITORY HERE
    @Autowired ProductsRepository productsRepository;

    @GetMapping("/customer_order/{id}")
    public ResponseEntity<CustomerOrder> getCustomerOrder(@PathVariable("id")long id){

        Optional<CustomerOrder> customerOrder = customerOrderRepository.findById(id);

        return customerOrder.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //THIS IS NOT GOOD FORM. You should NOT have the products repository in this controller. Instead create a service which handles the repository stuff
//    @PutMapping("/{customer_order_id}/products/{product_id}")
//    CustomerOrder orderProducts(
//            @PathVariable long customer_order_id,
//            @PathVariable long product_id)
//    {
//        CustomerOrder customerOrder = customerOrderRepository.getOne(customer_order_id);
//        Products products = productsRepository.getOne(product_id);
//    }
}
