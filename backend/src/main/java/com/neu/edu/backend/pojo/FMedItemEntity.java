package com.neu.edu.backend.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "f_med_item", schema = "cloudhospital", catalog = "")
public class FMedItemEntity {
    private String id;
    private String itemCode;
    private String itemName;
    private String format;
    private String price;
    private String expClassId;
    private String deptId;
    private String mnemonicCode;
    private String recordType;
    private String creationDate;

    @Id
    @Column(name = "id", nullable = false, length = 11)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "item_code", nullable = true, length = 11)
    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    @Basic
    @Column(name = "item_name", nullable = true, length = 64)
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Basic
    @Column(name = "format", nullable = true, length = 64)
    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Basic
    @Column(name = "price", nullable = true, length = 11)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "exp_class_id", nullable = true, length = 11)
    public String getExpClassId() {
        return expClassId;
    }

    public void setExpClassId(String expClassId) {
        this.expClassId = expClassId;
    }

    @Basic
    @Column(name = "dept_id", nullable = true, length = 11)
    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    @Basic
    @Column(name = "mnemonic_code", nullable = true, length = 64)
    public String getMnemonicCode() {
        return mnemonicCode;
    }

    public void setMnemonicCode(String mnemonicCode) {
        this.mnemonicCode = mnemonicCode;
    }

    @Basic
    @Column(name = "record_type", nullable = true, length = 11)
    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    @Basic
    @Column(name = "creation_date", nullable = true, length = 11)
    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FMedItemEntity that = (FMedItemEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(itemCode, that.itemCode) &&
                Objects.equals(itemName, that.itemName) &&
                Objects.equals(format, that.format) &&
                Objects.equals(price, that.price) &&
                Objects.equals(expClassId, that.expClassId) &&
                Objects.equals(deptId, that.deptId) &&
                Objects.equals(mnemonicCode, that.mnemonicCode) &&
                Objects.equals(recordType, that.recordType) &&
                Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemCode, itemName, format, price, expClassId, deptId, mnemonicCode, recordType, creationDate);
    }
}
