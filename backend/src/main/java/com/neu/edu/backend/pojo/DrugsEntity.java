package com.neu.edu.backend.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "drugs", schema = "cloudhospital", catalog = "")
public class DrugsEntity {
    private String id;
    private String drugsCode;
    private String drugsName;
    private String drugsFormat;
    private String drugsUnit;
    private String manufacturer;
    private double drugsPrice;
    private String mnemonicCode;
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
    @Column(name = "drugs_code", nullable = false, length = 64)
    public String getDrugsCode() {
        return drugsCode;
    }

    public void setDrugsCode(String drugsCode) {
        this.drugsCode = drugsCode;
    }

    @Basic
    @Column(name = "drugs_name", nullable = false, length = 64)
    public String getDrugsName() {
        return drugsName;
    }

    public void setDrugsName(String drugsName) {
        this.drugsName = drugsName;
    }

    @Basic
    @Column(name = "drugs_format", nullable = false, length = 64)
    public String getDrugsFormat() {
        return drugsFormat;
    }

    public void setDrugsFormat(String drugsFormat) {
        this.drugsFormat = drugsFormat;
    }

    @Basic
    @Column(name = "drugs_unit", nullable = false, length = 1)
    public String getDrugsUnit() {
        return drugsUnit;
    }

    public void setDrugsUnit(String drugsUnit) {
        this.drugsUnit = drugsUnit;
    }

    @Basic
    @Column(name = "manufacturer", nullable = true, length = 64)
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Basic
    @Column(name = "drugs_price", nullable = false, precision = 0)
    public double getDrugsPrice() {
        return drugsPrice;
    }

    public void setDrugsPrice(double drugsPrice) {
        this.drugsPrice = drugsPrice;
    }

    @Basic
    @Column(name = "mnemonic_code", nullable = false, length = 64)
    public String getMnemonicCode() {
        return mnemonicCode;
    }

    public void setMnemonicCode(String mnemonicCode) {
        this.mnemonicCode = mnemonicCode;
    }

    @Basic
    @Column(name = "creation_date", nullable = false, length = 11)
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
        DrugsEntity that = (DrugsEntity) o;
        return Double.compare(that.drugsPrice, drugsPrice) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(drugsCode, that.drugsCode) &&
                Objects.equals(drugsName, that.drugsName) &&
                Objects.equals(drugsFormat, that.drugsFormat) &&
                Objects.equals(drugsUnit, that.drugsUnit) &&
                Objects.equals(manufacturer, that.manufacturer) &&
                Objects.equals(mnemonicCode, that.mnemonicCode) &&
                Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, drugsCode, drugsName, drugsFormat, drugsUnit, manufacturer, drugsPrice, mnemonicCode, creationDate);
    }
}
