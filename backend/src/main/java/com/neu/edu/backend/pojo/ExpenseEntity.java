package com.neu.edu.backend.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "expense", schema = "cloudhospital", catalog = "")
public class ExpenseEntity {
    private int medicalHistoryId;
    private String name;
    private String itemName;
    private BigDecimal price;
    private String amount;
    private String state;

    @Id
    @Column(name = "medicalHistoryId", nullable = false)
    public int getMedicalHistoryId() {
        return medicalHistoryId;
    }

    public void setMedicalHistoryId(int medicalHistoryId) {
        this.medicalHistoryId = medicalHistoryId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "itemName", nullable = true, length = 255)
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "amount", nullable = true, length = 255)
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "state", nullable = true, length = 255)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpenseEntity that = (ExpenseEntity) o;
        return medicalHistoryId == that.medicalHistoryId &&
                Objects.equals(name, that.name) &&
                Objects.equals(itemName, that.itemName) &&
                Objects.equals(price, that.price) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicalHistoryId, name, itemName, price, amount, state);
    }
}
