package com.neu.edu.backend.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dise_category", schema = "cloudhospital", catalog = "")
public class DiseCategoryEntity {
    private String id;
    private String diseCategoryCode;
    private String diseCategoryName;
    private String sequenceNumber;
    private String diseCategoryType;

    @Id
    @Column(name = "id", nullable = false, length = 11)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "dise_category_code", nullable = true, length = 64)
    public String getDiseCategoryCode() {
        return diseCategoryCode;
    }

    public void setDiseCategoryCode(String diseCategoryCode) {
        this.diseCategoryCode = diseCategoryCode;
    }

    @Basic
    @Column(name = "dise_category_name", nullable = true, length = 64)
    public String getDiseCategoryName() {
        return diseCategoryName;
    }

    public void setDiseCategoryName(String diseCategoryName) {
        this.diseCategoryName = diseCategoryName;
    }

    @Basic
    @Column(name = "sequence_number", nullable = true, length = 64)
    public String getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    @Basic
    @Column(name = "dise_category_type", nullable = true, length = 1)
    public String getDiseCategoryType() {
        return diseCategoryType;
    }

    public void setDiseCategoryType(String diseCategoryType) {
        this.diseCategoryType = diseCategoryType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiseCategoryEntity that = (DiseCategoryEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(diseCategoryCode, that.diseCategoryCode) &&
                Objects.equals(diseCategoryName, that.diseCategoryName) &&
                Objects.equals(sequenceNumber, that.sequenceNumber) &&
                Objects.equals(diseCategoryType, that.diseCategoryType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, diseCategoryCode, diseCategoryName, sequenceNumber, diseCategoryType);
    }
}
