package com.JoysToysApplication.JoysToysApplication.Entity;

import com.JoysToysApplication.JoysToysApplication.Entity.Customer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "payment_information", schema = "public")
public class PaymentInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long payment_information_id;

    @Column
    private String credit_card_number;

    //kind refers to "kind of payment"
    @Column
    private int kind;

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customer_id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
    @JsonIgnoreProperties("paymentInformationList")
    private Customer customer;

    public PaymentInformation() {

    }

    public PaymentInformation(long payment_information_id, String credit_card_number, int kind, long customer_id) {
        this.payment_information_id = payment_information_id;
        this.credit_card_number = credit_card_number;
        this.kind = kind;
        this.customer_id = customer_id;
    }

    public long getPayment_information_id() {
        return payment_information_id;
    }

    public String getCredit_card_number() {
        return credit_card_number;
    }

    public int getKind() {
        return kind;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setPayment_information_id(long payment_information_id) {
        this.payment_information_id = payment_information_id;
    }

    public void setCredit_card_number(String credit_card_number) {
        this.credit_card_number = credit_card_number;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

}
