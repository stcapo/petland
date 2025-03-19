package com.petland.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ExpenseRecord {
    private Integer id;
    private String description;
    private BigDecimal amount;
    private Date createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public String toString() {
        return "ExpenseRecord{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", createdAt=" + createdAt +
                '}';
    }
}
