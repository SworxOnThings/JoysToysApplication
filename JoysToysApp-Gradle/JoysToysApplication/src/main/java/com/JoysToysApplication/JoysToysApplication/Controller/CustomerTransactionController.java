package com.JoysToysApplication.JoysToysApplication.Controller;

import com.JoysToysApplication.JoysToysApplication.Entity.CustomerTransaction;
import com.JoysToysApplication.JoysToysApplication.Repository.CustomerTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CustomerTransactionController {

    @Autowired
    CustomerTransactionRepository customerTransactionRepository;

    @GetMapping("/customer_transaction/{id}")
    public ResponseEntity<CustomerTransaction> getCustomerTransaction(@PathVariable("id")long id){
        Optional<CustomerTransaction> customerTransaction = customerTransactionRepository.findById(id);

        return customerTransaction.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
