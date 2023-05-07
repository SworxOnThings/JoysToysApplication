package com.JoysToysApplication.JoysToysApplication.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "inventory_order")
public class InventoryOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long inventory_order_id;

    @Column
    private java.sql.Timestamp inventory_order_date;

    @Column(name = "purchasingpriceperunit")
    private BigDecimal purchasingPricePerUnit;

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long product_id;

    @OneToMany(mappedBy = "inventoryOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RestockingLogistics> productsOrdered = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "inventoryOrder")
    @JsonManagedReference
    private InventoryTransaction inventoryTransaction;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "inventoryOrder")
    @JsonManagedReference
    private Delivery delivery;

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long supplier_id;

    public InventoryOrder(){

    }

    public InventoryOrder(long inventory_order_id, Timestamp inventory_order_date, BigDecimal purchasingPricePerUnit, long product_id, Set<RestockingLogistics> productsOrdered, InventoryTransaction inventoryTransaction, Delivery delivery, long supplier_id) {
        this.inventory_order_id = inventory_order_id;
        this.inventory_order_date = inventory_order_date;
        this.purchasingPricePerUnit = purchasingPricePerUnit;
        this.product_id = product_id;
        this.productsOrdered = productsOrdered;
        this.inventoryTransaction = inventoryTransaction;
        this.delivery = delivery;
        this.supplier_id = supplier_id;
    }

    public long getInventory_order_id() {
        return inventory_order_id;
    }

    public Timestamp getInventory_order_date() {
        return inventory_order_date;
    }

    public BigDecimal getPurchasingPricePerUnit() {
        return purchasingPricePerUnit;
    }


    public long getProduct_id() {
        return product_id;
    }


    public InventoryTransaction getInventoryTransaction() {
        return inventoryTransaction;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public Set<RestockingLogistics> getProductsOrdered() {
        return productsOrdered;
    }


    public long getSupplier_id() {
        return supplier_id;
    }
}
