package com.neu.edu.backend.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "prescription", schema = "cloudhospital", catalog = "")
public class PrescriptionEntity {
    private int id;
    private Integer medicalHistoryId;
    private Integer registrationId;
    private Integer doctorId;
    private String prescriptionName;
    private Timestamp time;
    private Integer state;

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
    @Column(name = "doctor_id", nullable = true)
    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    @Basic
    @Column(name = "prescription_name", nullable = true, length = 255)
    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        this.prescriptionName = prescriptionName;
    }

    @Basic
    @Column(name = "time", nullable = true)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "state", nullable = true)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrescriptionEntity that = (PrescriptionEntity) o;
        return id == that.id &&
                Objects.equals(medicalHistoryId, that.medicalHistoryId) &&
                Objects.equals(registrationId, that.registrationId) &&
                Objects.equals(doctorId, that.doctorId) &&
                Objects.equals(prescriptionName, that.prescriptionName) &&
                Objects.equals(time, that.time) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, medicalHistoryId, registrationId, doctorId, prescriptionName, time, state);
    }
}
