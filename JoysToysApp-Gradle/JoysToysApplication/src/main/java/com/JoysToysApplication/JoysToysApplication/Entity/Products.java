package com.JoysToysApplication.JoysToysApplication.Entity;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;


@Entity
@Data
@Table(name = "products", schema = "public")
public class Products implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long product_id;

    @Transient
    @Convert(converter = JsonNode.class)
    private JsonNode jsonNode;

    @Column
    private String product_name;

    @Column
    private java.math.BigDecimal price;

    @Column
    private int product_stock;


    @Column
    private String imageURL;

    //Products is part of the Join Table CustomerOrderProductAssociation
    @OneToMany(mappedBy = "products")
    private Set<CustomerOrderProductAssociation> customerOrders = new HashSet<>();


    //One category can contain Many products
    //This is a nested entity
    @ManyToOne(targetEntity = Categories.class, optional = false)
    @JoinColumn(name = "category")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Categories category;


    @OneToMany(mappedBy = "products")
    private Set<RestockingLogistics> inventoryOrder = new HashSet<>();

    public Products() {

    }

    public Products(long product_id, String product_name, BigDecimal price, int product_stock, Set<CustomerOrderProductAssociation> customerOrders, Set<Categories> categoriesSet) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
        this.product_stock = product_stock;
        this.customerOrders = customerOrders;
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

    public Categories getCategory() {
        return category;
    }

    public String getImageURL() {
        return imageURL;
    }

    public Set<CustomerOrderProductAssociation> getCustomerOrders() {
        return customerOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Products products)) return false;
        return getProduct_id() == products.getProduct_id();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProduct_id());
    }
}
