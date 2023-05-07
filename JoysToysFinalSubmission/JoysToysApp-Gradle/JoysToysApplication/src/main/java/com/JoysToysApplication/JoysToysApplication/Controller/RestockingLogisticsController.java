package com.JoysToysApplication.JoysToysApplication.Controller;

import com.JoysToysApplication.JoysToysApplication.Entity.RestockingLogistics;
import com.JoysToysApplication.JoysToysApplication.Repository.RestockingLogisticsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RestockingLogisticsController {

    RestockingLogisticsRepository restockingLogisticsRepository;

    @GetMapping("/restocking_logistics/{id}")
    public ResponseEntity<RestockingLogistics> getRestockingLogistics(@PathVariable("id")long id){

        Optional<RestockingLogistics> restockingLogistics = restockingLogisticsRepository.findById(id);

        return restockingLogistics.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
