package com.JoysToysApplication.JoysToysApplication.DTO;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class ReceiptDTO {

    private long customer_transaction_id;

    private long customer_id;

    private BigDecimal amount_paid;

    private List<ProductWithQuantity> productsOrdered;

    private java.sql.Timestamp orderDate;

    public ReceiptDTO(long customer_transaction_id, long customer_id, BigDecimal amount_paid, List<ProductWithQuantity> productsOrdered, Timestamp orderDate) {
        this.customer_transaction_id = customer_transaction_id;
        this.customer_id = customer_id;
        this.amount_paid = amount_paid;
        this.productsOrdered = productsOrdered;
        this.orderDate = orderDate;
    }

    public BigDecimal getAmount_paid() {
        return amount_paid;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

}
