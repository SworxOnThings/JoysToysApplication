package com.JoysToysApplication.JoysToysApplication.Services;
import com.JoysToysApplication.JoysToysApplication.Entity.Customer;
import com.JoysToysApplication.JoysToysApplication.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@Service
public class CustomerService implements UserDetailsService{



    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Customer customer = customerRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        String passwordHash = new String(customer.getPasswordHash(), StandardCharsets.UTF_8);

        return new org.springframework.security.core.userdetails.User(
                customer.getUsername(), passwordHash, new ArrayList<>());
    }


    public BCryptPasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

}
