package com.JoysToysApplication.JoysToysApplication.Controller;

import com.JoysToysApplication.JoysToysApplication.Entity.InventoryTransaction;
import com.JoysToysApplication.JoysToysApplication.Repository.InventoryTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class InventoryTransactionController {

    @Autowired
    InventoryTransactionRepository inventoryTransactionRepository;

    @GetMapping("/inventory_transaction/{id}")
    public ResponseEntity<InventoryTransaction> getInventoryTransaction(@PathVariable("id") long id){

        Optional<InventoryTransaction> inventoryTransaction = inventoryTransactionRepository.findById(id);

        return inventoryTransaction.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
}
