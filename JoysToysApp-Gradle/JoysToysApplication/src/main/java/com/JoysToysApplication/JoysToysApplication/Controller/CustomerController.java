package com.JoysToysApplication.JoysToysApplication.Controller;
import com.JoysToysApplication.JoysToysApplication.DTO.CustomerDTO;
import com.JoysToysApplication.JoysToysApplication.Repository.CustomerRepository;
import com.JoysToysApplication.JoysToysApplication.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    //This is a PATH variable
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id) {
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


    @GetMapping("/customer")
    public ResponseEntity<Customer> getCustomerByUsername(@RequestParam("username") String username) {
        Optional<Customer> customer = customerRepository.findByUsername(username);

        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/customer/registration")
    public ResponseEntity<Customer> registerCustomer(@RequestBody CustomerDTO customerDTO){
        Customer customer = new Customer();


        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setAddress(customerDTO.getAddress());
        customer.setPhonenumber(customerDTO.getPhonenumber());
        customer.setUsername(customerDTO.getUsername());

//        String dataString = new String(customerDTO.getPassword(), StandardCharsets.UTF_8);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hash = encoder.encode(customerDTO.getPassword());
        byte[] utf8Bytes = hash.getBytes(StandardCharsets.UTF_8);
        customer.setPasswordHash(utf8Bytes);

        customer = customerRepository.save(customer);

        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

}
