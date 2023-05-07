package com.JoysToysApplication.JoysToysApplication.Services;

import com.JoysToysApplication.JoysToysApplication.Entity.CustomerOrder;
import com.JoysToysApplication.JoysToysApplication.Repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerOrderProductService {

    @Autowired CustomerOrderRepository customerOrderRepository;

    public ResponseEntity<Object> getAllCustomerOrders(){
        List<CustomerOrder> customerOrders = customerOrderRepository.findAll();
        if(customerOrders.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(customerOrders, HttpStatus.OK);
    }
}
