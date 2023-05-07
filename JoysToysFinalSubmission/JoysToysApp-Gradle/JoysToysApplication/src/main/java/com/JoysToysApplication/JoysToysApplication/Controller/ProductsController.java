package com.JoysToysApplication.JoysToysApplication.Controller;

import com.JoysToysApplication.JoysToysApplication.Entity.Categories;
import com.JoysToysApplication.JoysToysApplication.Entity.Products;
import com.JoysToysApplication.JoysToysApplication.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductsController {

    @Autowired
    ProductsRepository productsRepository;

    @GetMapping("/products/{id}")
    public ResponseEntity<Products> getProducts(@PathVariable("id")long id){
        Optional<Products> products = productsRepository.findById(id);

        return products.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/products")
    public ResponseEntity<List<Products>> getAllProducts(){
        List<Products> products = productsRepository.findAll();

        return ResponseEntity.ok(products);
    }


    @GetMapping("/products/product_category")
    public ResponseEntity<List<Products>> getProductsByCategory(@RequestParam("CategoryName") String category){
        List<Products> products = productsRepository.findByCategoryCategoryName(category);

        return ResponseEntity.ok(products);
    }



}
