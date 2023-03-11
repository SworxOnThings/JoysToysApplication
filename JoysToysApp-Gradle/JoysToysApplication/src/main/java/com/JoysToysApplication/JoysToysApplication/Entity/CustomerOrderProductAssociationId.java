package com.JoysToysApplication.JoysToysApplication.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CustomerOrderProductAssociationId implements Serializable {

    @Column(name = "customer_order_id")
    private long customer_order;

    @Column(name = "product_id")
    private long products;

    public long getCustomerOrder() {
        return customer_order;
    }

    public long getProduct() {
        return products;
    }

    public void setCustomerOrder(long customerOrder) {
        this.customer_order = customerOrder;
    }

    public void setProduct(long product) {
        this.products = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerOrderProductAssociationId that)) return false;
        return getCustomerOrder() == that.getCustomerOrder() && getProduct() == that.getProduct();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerOrder(), getProduct());
    }
}
