package com.JoysToysApplication.JoysToysApplication.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "customer_transactions", schema = "public")
public class CustomerTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public.customer_transactions_customer_transaction_id_seq")
    @SequenceGenerator(name = "public.customer_transactions_customer_transaction_id_seq", sequenceName = "public.customer_transactions_customer_transaction_id_seq", allocationSize = 1)
    private long customer_transaction_id;

    //data type in PostgreSQL is 'numeric'
    @Column
    private java.math.BigDecimal amount_paid;


    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long payment_information_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_order_id")
    @JsonBackReference
    private CustomerOrder customerOrder;

    public CustomerTransaction() {

    }

    public CustomerTransaction(BigDecimal amount_paid, long payment_information_id, CustomerOrder customerOrder) {
        this.amount_paid = amount_paid;
        this.payment_information_id = payment_information_id;
        this.customerOrder = customerOrder;
    }

    public long getCustomer_transaction_id() {
        return customer_transaction_id;
    }

    public BigDecimal getAmount_paid() {
        return amount_paid;
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


    public void setPayment_information_id(long payment_information_id) {
        this.payment_information_id = payment_information_id;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }
}
