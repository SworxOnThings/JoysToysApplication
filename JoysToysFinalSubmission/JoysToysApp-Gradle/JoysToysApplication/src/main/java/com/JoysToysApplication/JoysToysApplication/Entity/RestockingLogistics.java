package com.JoysToysApplication.JoysToysApplication.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "restocking_logistics")
public class RestockingLogistics implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long restocking_logistics_id;

    @ManyToOne(targetEntity = Products.class, optional = false)
    @JoinColumn(name = "product_id")
    private Products products;

    @ManyToOne(targetEntity = InventoryOrder.class, optional = false)
    @JoinColumn(name = "inventory_order_id")
    private InventoryOrder inventoryOrder;

    @Column
    private int quantity;

    public RestockingLogistics(){

    }

    public RestockingLogistics(long restocking_logistics_id, Products products, InventoryOrder inventoryOrder, int quantity) {
        this.restocking_logistics_id = restocking_logistics_id;
        this.products = products;
        this.inventoryOrder = inventoryOrder;
        this.quantity = quantity;
    }

    public long getRestocking_logistics_id() {
        return restocking_logistics_id;
    }

    public Products getProducts() {
        return products;
    }

    public InventoryOrder getInventoryOrder() {
        return inventoryOrder;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RestockingLogistics that)) return false;
        return getRestocking_logistics_id() == that.getRestocking_logistics_id() && getQuantity() == that.getQuantity() && Objects.equals(getProducts(), that.getProducts()) && Objects.equals(getInventoryOrder(), that.getInventoryOrder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRestocking_logistics_id(), getProducts(), getInventoryOrder(), getQuantity());
    }

}
