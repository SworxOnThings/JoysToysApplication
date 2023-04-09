package com.JoysToysApplication.JoysToysApplication.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long delivery_id;

    @Column
    private java.sql.Timestamp expected_delivery_date;

    @Column
    private java.sql.Timestamp arrival_date;

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long inventory_order_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory_order_id", insertable = false, updatable = false)
    @JsonBackReference
    private InventoryOrder inventoryOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    public Delivery(){

    }

    public Delivery(long delivery_id, Timestamp expected_delivery_date, Timestamp arrival_date, long inventory_order_id, InventoryOrder inventoryOrder, long supplier_id, Supplier supplier) {
        this.delivery_id = delivery_id;
        this.expected_delivery_date = expected_delivery_date;
        this.arrival_date = arrival_date;
        this.inventory_order_id = inventory_order_id;
        this.inventoryOrder = inventoryOrder;
        this.supplier = supplier;
    }

    public long getDelivery_id() {
        return delivery_id;
    }

    public Timestamp getExpected_delivery_date() {
        return expected_delivery_date;
    }

    public Timestamp getArrival_date() {
        return arrival_date;
    }

    public long getInventory_order_id() {
        return inventory_order_id;
    }

    public InventoryOrder getInventoryOrder() {
        return inventoryOrder;
    }

    public Supplier getSupplier() {
        return supplier;
    }

}
