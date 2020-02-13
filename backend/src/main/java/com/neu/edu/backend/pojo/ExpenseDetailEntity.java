package com.neu.edu.backend.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "expense_detail", schema = "cloudhospital", catalog = "")
public class ExpenseDetailEntity {
    private int id;
    private int registrationId;
    private int invoiceId;
    private int itemType;
    private String itemName;
    private int itemPrice;
    private int amount;
    private int departmentId;
    private Timestamp payRefundTime;
    private int payUserId;
    private int payType;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "registration_id", nullable = false)
    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    @Basic
    @Column(name = "invoice_id", nullable = false)
    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Basic
    @Column(name = "item_type", nullable = false)
    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    @Basic
    @Column(name = "item_name", nullable = false, length = 64)
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Basic
    @Column(name = "item_price", nullable = false)
    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Basic
    @Column(name = "amount", nullable = false)
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "department_id", nullable = false)
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "pay_refund_time", nullable = false)
    public Timestamp getPayRefundTime() {
        return payRefundTime;
    }

    public void setPayRefundTime(Timestamp payRefundTime) {
        this.payRefundTime = payRefundTime;
    }

    @Basic
    @Column(name = "pay_user_id", nullable = false)
    public int getPayUserId() {
        return payUserId;
    }

    public void setPayUserId(int payUserId) {
        this.payUserId = payUserId;
    }

    @Basic
    @Column(name = "pay_type", nullable = false)
    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpenseDetailEntity that = (ExpenseDetailEntity) o;
        return id == that.id &&
                registrationId == that.registrationId &&
                invoiceId == that.invoiceId &&
                itemType == that.itemType &&
                itemPrice == that.itemPrice &&
                amount == that.amount &&
                departmentId == that.departmentId &&
                payUserId == that.payUserId &&
                payType == that.payType &&
                Objects.equals(itemName, that.itemName) &&
                Objects.equals(payRefundTime, that.payRefundTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, registrationId, invoiceId, itemType, itemName, itemPrice, amount, departmentId, payRefundTime, payUserId, payType);
    }
}
