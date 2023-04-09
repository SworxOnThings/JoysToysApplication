package com.JoysToysApplication.JoysToysApplication.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "inventory_transactions")
public class InventoryTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long transaction_id;

    @Column
    private BigDecimal amount_paid;

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long inventory_order_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory_order_id", insertable = false, updatable = false)
    @JsonBackReference
    private InventoryOrder inventoryOrder;

    public InventoryTransaction(){

    }

    public InventoryTransaction(long transaction_id, BigDecimal amount_paid, long inventory_order_id, InventoryOrder inventoryOrder) {
        this.transaction_id = transaction_id;
        this.amount_paid = amount_paid;
        this.inventory_order_id = inventory_order_id;
        this.inventoryOrder = inventoryOrder;
    }

    public long getTransaction_id() {
        return transaction_id;
    }

    public BigDecimal getAmount_paid() {
        return amount_paid;
    }

    public long getInventory_order_id() {
        return inventory_order_id;
    }

    public InventoryOrder getInventoryOrder() {
        return inventoryOrder;
    }

}
