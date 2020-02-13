package com.neu.edu.backend.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "constant_item", schema = "cloudhospital", catalog = "")
public class ConstantItemEntity {
    private String id;
    private String constantTypeId;
    private String constantCode;
    private String constantName;
    private String price;

    @Id
    @Column(name = "id", nullable = false, length = 11)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "constant_type_id", nullable = false, length = 11)
    public String getConstantTypeId() {
        return constantTypeId;
    }

    public void setConstantTypeId(String constantTypeId) {
        this.constantTypeId = constantTypeId;
    }

    @Basic
    @Column(name = "constant_code", nullable = false, length = 64)
    public String getConstantCode() {
        return constantCode;
    }

    public void setConstantCode(String constantCode) {
        this.constantCode = constantCode;
    }

    @Basic
    @Column(name = "constant_name", nullable = false, length = 64)
    public String getConstantName() {
        return constantName;
    }

    public void setConstantName(String constantName) {
        this.constantName = constantName;
    }

    @Basic
    @Column(name = "price", nullable = true, length = 10)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConstantItemEntity that = (ConstantItemEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(constantTypeId, that.constantTypeId) &&
                Objects.equals(constantCode, that.constantCode) &&
                Objects.equals(constantName, that.constantName) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, constantTypeId, constantCode, constantName, price);
    }
}
