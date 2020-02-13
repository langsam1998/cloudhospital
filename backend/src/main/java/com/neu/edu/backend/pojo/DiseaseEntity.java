package com.neu.edu.backend.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "disease", schema = "cloudhospital", catalog = "")
public class DiseaseEntity {
    private int id;
    private String diseaseCode;
    private String diseaseName;
    private String diseaseIcd;
    private String diseCategoryId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "disease_code", nullable = true, length = 64)
    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    @Basic
    @Column(name = "disease_name", nullable = true, length = 64)
    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    @Basic
    @Column(name = "disease_ICD", nullable = true, length = 11)
    public String getDiseaseIcd() {
        return diseaseIcd;
    }

    public void setDiseaseIcd(String diseaseIcd) {
        this.diseaseIcd = diseaseIcd;
    }

    @Basic
    @Column(name = "dise_category_id", nullable = true, length = 11)
    public String getDiseCategoryId() {
        return diseCategoryId;
    }

    public void setDiseCategoryId(String diseCategoryId) {
        this.diseCategoryId = diseCategoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiseaseEntity that = (DiseaseEntity) o;
        return id == that.id &&
                Objects.equals(diseaseCode, that.diseaseCode) &&
                Objects.equals(diseaseName, that.diseaseName) &&
                Objects.equals(diseaseIcd, that.diseaseIcd) &&
                Objects.equals(diseCategoryId, that.diseCategoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, diseaseCode, diseaseName, diseaseIcd, diseCategoryId);
    }
}
