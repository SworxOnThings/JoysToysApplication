package com.JoysToysApplication.JoysToysApplication.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "products")
@Table(name = "products", schema = "public")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long product_id;

    @Column
    private String product_name;

    @Column
    private java.math.BigDecimal price;

    @Column
    private int product_stock;


    //Products is part of the Join Table CustomerOrderProductAssociation
    @OneToMany(mappedBy = "products")
    private Set<CustomerOrderProductAssociation> customerOrders = new HashSet<>();

    public Products() {

    }

    public Products(long product_id, String product_name, BigDecimal price, int product_stock) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
        this.product_stock = product_stock;
    }

    public long getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getProduct_stock() {
        return product_stock;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setProduct_stock(int product_stock) {
        this.product_stock = product_stock;
    }

    public Set<CustomerOrderProductAssociation> getOrderedProductsSet() {
        return customerOrders;
    }
}
