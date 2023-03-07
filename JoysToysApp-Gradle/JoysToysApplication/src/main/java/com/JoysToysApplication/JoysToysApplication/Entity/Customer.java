package com.JoysToysApplication.JoysToysApplication.Entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * an entity is an object-oriented representation of a tuple of a database table.
 */
@Entity
@Table(name = "customer", schema = "public")
public class Customer {

    //auto-id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customer_id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "phonenumber")
    private String phonenumber;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.ALL)
    private List<PaymentInformation> paymentInformationList = new ArrayList<>();

    public Customer() {

    }

    public Customer(long id, String name, String email, String address, String phonenumber) {
        this.customer_id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phonenumber = phonenumber;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setCustomer_id(long id) {
        this.customer_id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
