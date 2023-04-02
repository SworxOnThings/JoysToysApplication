package com.JoysToysApplication.JoysToysApplication.Controller;

import com.JoysToysApplication.JoysToysApplication.Entity.Categories;
import com.JoysToysApplication.JoysToysApplication.Repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CategoriesController {

    @Autowired
    CategoriesRepository categoriesRepository;

    @GetMapping("/categories/{id}")
    public ResponseEntity<Categories> getCategories(@PathVariable("id")long id){
        Optional<Categories> category = categoriesRepository.findById(id);

        return category.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
