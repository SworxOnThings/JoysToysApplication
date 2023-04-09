package com.JoysToysApplication.JoysToysApplication.Controller;

import com.JoysToysApplication.JoysToysApplication.Entity.Delivery;
import com.JoysToysApplication.JoysToysApplication.Repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class DeliveryController {

    @Autowired
    DeliveryRepository deliveryRepository;

    @GetMapping("/delivery/{id}")
    public ResponseEntity<Delivery> getDelivery(@PathVariable("id")long id){

        Optional<Delivery> delivery = deliveryRepository.findById(id);

        return delivery.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
}
