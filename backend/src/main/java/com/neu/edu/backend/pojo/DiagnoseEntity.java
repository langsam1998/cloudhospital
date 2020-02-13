package com.neu.edu.backend.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "diagnose", schema = "cloudhospital", catalog = "")
public class DiagnoseEntity {
    private int id;
    private Integer medicalHistoryId;
    private Integer registrationId;
    private Integer diseaseId;
    private Integer diagnoseType;
    private Date date;
    private Integer diagnoseTime;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "medical_history_id", nullable = true)
    public Integer getMedicalHistoryId() {
        return medicalHistoryId;
    }

    public void setMedicalHistoryId(Integer medicalHistoryId) {
        this.medicalHistoryId = medicalHistoryId;
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
    @Column(name = "disease_id", nullable = true)
    public Integer getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    @Basic
    @Column(name = "diagnose_type", nullable = true)
    public Integer getDiagnoseType() {
        return diagnoseType;
    }

    public void setDiagnoseType(Integer diagnoseType) {
        this.diagnoseType = diagnoseType;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "diagnose_time", nullable = true)
    public Integer getDiagnoseTime() {
        return diagnoseTime;
    }

    public void setDiagnoseTime(Integer diagnoseTime) {
        this.diagnoseTime = diagnoseTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiagnoseEntity that = (DiagnoseEntity) o;
        return id == that.id &&
                Objects.equals(medicalHistoryId, that.medicalHistoryId) &&
                Objects.equals(registrationId, that.registrationId) &&
                Objects.equals(diseaseId, that.diseaseId) &&
                Objects.equals(diagnoseType, that.diagnoseType) &&
                Objects.equals(date, that.date) &&
                Objects.equals(diagnoseTime, that.diagnoseTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, medicalHistoryId, registrationId, diseaseId, diagnoseType, date, diagnoseTime);
    }
}
