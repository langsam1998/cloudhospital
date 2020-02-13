package com.neu.edu.backend.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "constant_type", schema = "cloudhospital", catalog = "")
public class ConstantTypeEntity {
    private String id;
    private String constantTypeCode;
    private String constantTypeName;

    @Id
    @Column(name = "id", nullable = false, length = 11)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "constant_type_code", nullable = true, length = 64)
    public String getConstantTypeCode() {
        return constantTypeCode;
    }

    public void setConstantTypeCode(String constantTypeCode) {
        this.constantTypeCode = constantTypeCode;
    }

    @Basic
    @Column(name = "constant_type_name", nullable = true, length = 64)
    public String getConstantTypeName() {
        return constantTypeName;
    }

    public void setConstantTypeName(String constantTypeName) {
        this.constantTypeName = constantTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConstantTypeEntity that = (ConstantTypeEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(constantTypeCode, that.constantTypeCode) &&
                Objects.equals(constantTypeName, that.constantTypeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, constantTypeCode, constantTypeName);
    }
}
