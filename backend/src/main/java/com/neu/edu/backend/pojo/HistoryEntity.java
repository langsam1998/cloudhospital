package com.neu.edu.backend.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "history", schema = "cloudhospital", catalog = "")
public class HistoryEntity {
    private int id;
    private Integer medicalHistoryId;
    private String chiefComplaint;
    private String allergy;
    private String physicalExamination;
    private String historyOfPresent;
    private String treatmentCondition;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "medicalHistoryId", nullable = true)
    public Integer getMedicalHistoryId() {
        return medicalHistoryId;
    }

    public void setMedicalHistoryId(Integer medicalHistoryId) {
        this.medicalHistoryId = medicalHistoryId;
    }

    @Basic
    @Column(name = "chiefComplaint", nullable = true, length = 255)
    public String getChiefComplaint() {
        return chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
    }

    @Basic
    @Column(name = "allergy", nullable = true, length = 255)
    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    @Basic
    @Column(name = "physicalExamination", nullable = true, length = 255)
    public String getPhysicalExamination() {
        return physicalExamination;
    }

    public void setPhysicalExamination(String physicalExamination) {
        this.physicalExamination = physicalExamination;
    }

    @Basic
    @Column(name = "historyOfPresent", nullable = true, length = 255)
    public String getHistoryOfPresent() {
        return historyOfPresent;
    }

    public void setHistoryOfPresent(String historyOfPresent) {
        this.historyOfPresent = historyOfPresent;
    }

    @Basic
    @Column(name = "treatmentCondition", nullable = true, length = 255)
    public String getTreatmentCondition() {
        return treatmentCondition;
    }

    public void setTreatmentCondition(String treatmentCondition) {
        this.treatmentCondition = treatmentCondition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoryEntity that = (HistoryEntity) o;
        return id == that.id &&
                Objects.equals(medicalHistoryId, that.medicalHistoryId) &&
                Objects.equals(chiefComplaint, that.chiefComplaint) &&
                Objects.equals(allergy, that.allergy) &&
                Objects.equals(physicalExamination, that.physicalExamination) &&
                Objects.equals(historyOfPresent, that.historyOfPresent) &&
                Objects.equals(treatmentCondition, that.treatmentCondition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, medicalHistoryId, chiefComplaint, allergy, physicalExamination, historyOfPresent, treatmentCondition);
    }
}
