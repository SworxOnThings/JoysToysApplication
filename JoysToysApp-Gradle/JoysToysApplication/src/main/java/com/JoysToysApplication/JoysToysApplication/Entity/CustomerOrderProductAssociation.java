package com.JoysToysApplication.JoysToysApplication.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

//you might have to use this. Quantity is included in this association table.
@Entity
@Table(name = "customer_order_product_association")
public class CustomerOrderProductAssociation implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customer_order_product_association_id;

    @ManyToOne
    @JoinColumn(name = "customer_order_id")
    private CustomerOrder customer_order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products products;

    @Column
    private int quantity;

    public CustomerOrderProductAssociation() {

    }

    public CustomerOrderProductAssociation(long customer_order_product_association_id, CustomerOrder customer_order, Products products, int quantity) {
        this.customer_order_product_association_id = customer_order_product_association_id;
        this.customer_order = customer_order;
        this.products = products;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerOrderProductAssociation that)) return false;
        return customer_order_product_association_id == that.customer_order_product_association_id && getQuantity() == that.getQuantity() && Objects.equals(customer_order, that.customer_order) && Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer_order_product_association_id, customer_order, products, getQuantity());
    }
}

