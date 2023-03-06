package com.JoysToysApplication.JoysToysApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired CustomerRepository customerRepository;

    //This is a PATH variable
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id")long id){
        Optional<Customer> customer = customerRepository.findById(id);
        //what's going on with return line:
        /*
        if(customer.isPresent()){
            return ResponseEntity.ok(customer.get());
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
         */
        return customer.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
