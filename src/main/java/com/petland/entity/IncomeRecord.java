package com.petland.entity;

import java.math.BigDecimal;
import java.util.Date;

public class IncomeRecord {
    private Integer id;
    private Integer orderId;
    private BigDecimal amount;
    private Date createdAt;
    private Order order;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "IncomeRecord{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", amount=" + amount +
                ", createdAt=" + createdAt +
                ", order=" + order +
                '}';
    }
}
