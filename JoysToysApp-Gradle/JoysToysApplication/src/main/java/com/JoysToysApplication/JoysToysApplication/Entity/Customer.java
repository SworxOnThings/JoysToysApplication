package com.JoysToysApplication.JoysToysApplication.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "username")
    private String username;



    @Column(name = "password", columnDefinition = "bytea")
    private byte[] passwordHash;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.ALL)
    private List<PaymentInformation> paymentInformationList = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CustomerOrder> customerOrderList = new ArrayList<>();

    public Customer() {

    }

    public Customer(long customer_id, String name, String email, String address, String phonenumber, String username, byte[] passwordHash, List<PaymentInformation> paymentInformationList, List<CustomerOrder> customerOrderList) {
        this.customer_id = customer_id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phonenumber = phonenumber;
        this.username = username;
        this.passwordHash = passwordHash;
        this.paymentInformationList = paymentInformationList;
        this.customerOrderList = customerOrderList;
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

    @JsonIgnore
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    public byte[] getPasswordHash() {
        return passwordHash;
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
