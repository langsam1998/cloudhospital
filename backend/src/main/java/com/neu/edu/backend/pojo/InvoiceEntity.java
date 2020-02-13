package com.neu.edu.backend.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "invoice", schema = "cloudhospital", catalog = "")
public class InvoiceEntity {
    private int id;
    private Integer amount;
    private Timestamp date;
    private Integer registorId;
    private Integer registrationId;
    private String method;
    private Integer redNumber;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "amount", nullable = true)
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "registor_id", nullable = true)
    public Integer getRegistorId() {
        return registorId;
    }

    public void setRegistorId(Integer registorId) {
        this.registorId = registorId;
    }

    @Basic
    @Column(name = "registration_id", nullable = true)
    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    @Basic
    @Column(name = "method", nullable = true, length = 255)
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Basic
    @Column(name = "red_number", nullable = true)
    public Integer getRedNumber() {
        return redNumber;
    }

    public void setRedNumber(Integer redNumber) {
        this.redNumber = redNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceEntity that = (InvoiceEntity) o;
        return id == that.id &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(date, that.date) &&
                Objects.equals(registorId, that.registorId) &&
                Objects.equals(registrationId, that.registrationId) &&
                Objects.equals(method, that.method) &&
                Objects.equals(redNumber, that.redNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, date, registorId, registrationId, method, redNumber);
    }
}
