package com.JoysToysApplication.JoysToysApplication.Controller;

import com.JoysToysApplication.JoysToysApplication.Entity.InventoryOrder;
import com.JoysToysApplication.JoysToysApplication.Repository.InventoryOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class InventoryOrderController {

    @Autowired
    InventoryOrderRepository inventoryOrderRepository;

    @GetMapping("/inventory_order/{id}")
    public ResponseEntity<InventoryOrder> getInventoryOrder(@PathVariable("id")long id){

        Optional<InventoryOrder> inventoryOrder = inventoryOrderRepository.findById(id);

        return inventoryOrder.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
