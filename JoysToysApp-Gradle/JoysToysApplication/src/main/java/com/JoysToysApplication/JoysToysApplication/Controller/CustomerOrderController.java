package com.JoysToysApplication.JoysToysApplication.Controller;

import com.JoysToysApplication.JoysToysApplication.Entity.CustomerOrder;
import com.JoysToysApplication.JoysToysApplication.Repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CustomerOrderController {

    @Autowired CustomerOrderRepository customerOrderRepository;

    @GetMapping("/Customer_Order/{id}")
    public ResponseEntity<CustomerOrder> getCustomerOrder(@PathVariable("id")long id){

        Optional<CustomerOrder> customerOrder = customerOrderRepository.findById(id);

        return customerOrder.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
