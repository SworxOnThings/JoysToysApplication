package com.JoysToysApplication.JoysToysApplication.Controller;
import com.JoysToysApplication.JoysToysApplication.Config.JwtTokenUtil;
import com.JoysToysApplication.JoysToysApplication.DTO.AuthToken;
import com.JoysToysApplication.JoysToysApplication.DTO.CustomerDTO;
import com.JoysToysApplication.JoysToysApplication.DTO.LoginCustomerDTO;
import com.JoysToysApplication.JoysToysApplication.Repository.CustomerRepository;
import com.JoysToysApplication.JoysToysApplication.Entity.Customer;
import com.JoysToysApplication.JoysToysApplication.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.naming.AuthenticationException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

import static com.JoysToysApplication.JoysToysApplication.DTO.AuthToken.createGarbageAuthToken;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private CustomerService customerService;


    @RequestMapping(value = "/customer/token", method = RequestMethod.POST)
    public ResponseEntity<AuthToken> refreshToken(@RequestBody LoginCustomerDTO loginCustomerDTO) throws AuthenticationException {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginCustomerDTO.getUsername(), loginCustomerDTO.getPassword()));
        final Optional<Customer> customer = customerRepository.findByUsername(loginCustomerDTO.getUsername());
        if(customer.isEmpty()){
            AuthToken garbageAuthToken = createGarbageAuthToken(); // Create a "garbage" AuthToken or return a default one

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(garbageAuthToken);
        }

        final String token = jwtTokenUtil.generateToken(customer.get());
        return ResponseEntity.ok(new AuthToken(token, customer.get().getUsername()));
    }

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
