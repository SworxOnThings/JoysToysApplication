package com.JoysToysApplication.JoysToysApplication.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Customer_Order", schema = "public")
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customer_order_id;

    @Column
    private java.sql.Timestamp customer_order_date;

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customer_id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
    @JsonIgnoreProperties("customerOrderList")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "CustomerOrder")
    @JsonManagedReference
    private CustomerTransaction customerTransaction;

    public CustomerOrder() {

    }

    public CustomerOrder(long customer_order_id, Timestamp customer_order_date, long customer_id, Customer customer) {
        this.customer_order_id = customer_order_id;
        this.customer_order_date = customer_order_date;
        this.customer_id = customer_id;
        this.customer = customer;
    }

    public long getCustomer_order_id() {
        return customer_order_id;
    }

    public Timestamp getCustomer_order_date() {
        return customer_order_date;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer_order_id(long customer_order_id) {
        this.customer_order_id = customer_order_id;
    }

    public void setCustomer_order_date(Timestamp customer_order_date) {
        this.customer_order_date = customer_order_date;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}