package com.JoysToysApplication.JoysToysApplication.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer_order", schema = "public")
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public.customer_order_customer_order_id_seq")
    @SequenceGenerator(name = "public.customer_order_customer_order_id_seq", sequenceName = "public.customer_order_customer_order_id_seq", allocationSize = 1)
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

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customerOrder")
    @JsonManagedReference
    private CustomerTransaction customerTransaction;



    //CustomerOrder is the owner of the JoinTable CustomerOrderProductAssociation. One entity must be the owner.
    @OneToMany(mappedBy = "customer_order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CustomerOrderProductAssociation> orderedProductsSet = new HashSet<>();

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
        setCustomer_id(customer.getCustomer_id());
    }

    public Set<CustomerOrderProductAssociation> getOrderedProductsSet() {
        return orderedProductsSet;
    }

    public void addAssociation(CustomerOrderProductAssociation order){
        orderedProductsSet.add(order);
    }

}
