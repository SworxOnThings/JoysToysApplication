package com.JoysToysApplication.JoysToysApplication.Entity;

import jakarta.persistence.*;

@Entity(name = "products")
@Table(name = "products", schema = "public")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long product_id;
}
