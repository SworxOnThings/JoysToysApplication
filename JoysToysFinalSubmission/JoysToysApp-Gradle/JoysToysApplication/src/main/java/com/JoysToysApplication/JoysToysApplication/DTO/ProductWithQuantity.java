package com.JoysToysApplication.JoysToysApplication.DTO;

import com.JoysToysApplication.JoysToysApplication.Entity.Products;

public class ProductWithQuantity {

    private Products product;

    private int quantity;

    public ProductWithQuantity(Products product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Products getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

}
