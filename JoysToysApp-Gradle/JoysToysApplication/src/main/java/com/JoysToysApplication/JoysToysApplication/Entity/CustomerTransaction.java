package com.JoysToysApplication.JoysToysApplication.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "customer_transactions", schema = "public")
public class CustomerTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customer_transaction_id;

    //data type in PostgreSQL is 'numeric'
    @Column
    private java.math.BigDecimal amount_paid;

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customer_order_id;

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long payment_information_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_order_id", insertable = false, updatable = false)
    @JsonBackReference
    private CustomerOrder customerOrder;

    public CustomerTransaction() {

    }

    public CustomerTransaction(long customer_transaction_id, BigDecimal amount_paid, long customer_order_id, long payment_information_id, CustomerOrder customerOrder) {
        this.customer_transaction_id = customer_transaction_id;
        this.amount_paid = amount_paid;
        this.customer_order_id = customer_order_id;
        this.payment_information_id = payment_information_id;
        this.customerOrder = customerOrder;
    }

    public long getCustomer_transaction_id() {
        return customer_transaction_id;
    }

    public BigDecimal getAmount_paid() {
        return amount_paid;
    }

    public long getCustomer_order_id() {
        return customer_order_id;
    }

    public long getPayment_information_id() {
        return payment_information_id;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomer_transaction_id(long customer_transaction_id) {
        this.customer_transaction_id = customer_transaction_id;
    }

    public void setAmount_paid(BigDecimal amount_paid) {
        this.amount_paid = amount_paid;
    }

    public void setCustomer_order_id(long customer_order_id) {
        this.customer_order_id = customer_order_id;
    }

    public void setPayment_information_id(long payment_information_id) {
        this.payment_information_id = payment_information_id;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }
}
