package com.JoysToysApplication.JoysToysApplication.DTO;

import com.JoysToysApplication.JoysToysApplication.Deserializer.StringToByteArrayDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;

public class CustomerDTO {

    private String name;

    private String email;

    private String address;

    private String phonenumber;

    private String username;


    private String password;

    public CustomerDTO(String name, String email, String address, String phonenumber, String username, String password) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phonenumber = phonenumber;
        this.username = username;
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
