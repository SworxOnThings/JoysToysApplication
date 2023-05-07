package com.JoysToysApplication.JoysToysApplication.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class CustomerOrderDTO {

    //this is the stuff that is not autogenerated
    private long customer_id;

    private long payment_information_id;

    @JsonProperty("order")
    private Map<Long, Integer> order = new HashMap<>();

    public CustomerOrderDTO() {

    }

    public CustomerOrderDTO(long customer_id, long payment_information_id, Map<Long, Integer> order) {
        this.customer_id = customer_id;
        this.payment_information_id = payment_information_id;
        this.order = order;
    }

    public long getCustomer_id() {
        return customer_id;
    }


    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }


    public void setOrder(Map<Long, Integer> order) {
        this.order = order;
    }

    public Map<Long, Integer> getOrder() {
        return order;
    }

    public long getPayment_information_id() {
        return payment_information_id;
    }

    public void setPayment_information_id(long payment_information_id) {
        this.payment_information_id = payment_information_id;
    }
}
