package com.neu.edu.backend.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "examine_dispose_application", schema = "cloudhospital", catalog = "")
public class ExamineDisposeApplicationEntity {
    private String id;
    private String historyId;
    private String registrationId;
    private String itemId;
    private String itemName;
    private String requiment;
    private String part;
    private String isEmergency;
    private String amount;
    private Timestamp creatTime;
    private String doctorId;
    private String technicianDoctorId;
    private String resultDoctorId;
    private Timestamp examineTime;
    private String result;
    private Timestamp resultTime;
    private String state;
    private String type;

    @Id
    @Column(name = "id", nullable = false, length = 11)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "history_id", nullable = true, length = 11)
    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    @Basic
    @Column(name = "registration_id", nullable = true, length = 11)
    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    @Basic
    @Column(name = "item_id", nullable = true, length = 64)
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
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
    @Column(name = "requiment", nullable = true, length = 255)
    public String getRequiment() {
        return requiment;
    }

    public void setRequiment(String requiment) {
        this.requiment = requiment;
    }

    @Basic
    @Column(name = "part", nullable = true, length = 64)
    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    @Basic
    @Column(name = "is_emergency", nullable = true, length = 1)
    public String getIsEmergency() {
        return isEmergency;
    }

    public void setIsEmergency(String isEmergency) {
        this.isEmergency = isEmergency;
    }

    @Basic
    @Column(name = "amount", nullable = true, length = 11)
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "creat_time", nullable = true)
    public Timestamp getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Timestamp creatTime) {
        this.creatTime = creatTime;
    }

    @Basic
    @Column(name = "doctor_id", nullable = true, length = 11)
    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    @Basic
    @Column(name = "technician_doctor_id", nullable = true, length = 11)
    public String getTechnicianDoctorId() {
        return technicianDoctorId;
    }

    public void setTechnicianDoctorId(String technicianDoctorId) {
        this.technicianDoctorId = technicianDoctorId;
    }

    @Basic
    @Column(name = "result_doctor_id", nullable = true, length = 11)
    public String getResultDoctorId() {
        return resultDoctorId;
    }

    public void setResultDoctorId(String resultDoctorId) {
        this.resultDoctorId = resultDoctorId;
    }

    @Basic
    @Column(name = "examine_time", nullable = true)
    public Timestamp getExamineTime() {
        return examineTime;
    }

    public void setExamineTime(Timestamp examineTime) {
        this.examineTime = examineTime;
    }

    @Basic
    @Column(name = "result", nullable = true, length = 255)
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Basic
    @Column(name = "result_time", nullable = true)
    public Timestamp getResultTime() {
        return resultTime;
    }

    public void setResultTime(Timestamp resultTime) {
        this.resultTime = resultTime;
    }

    @Basic
    @Column(name = "state", nullable = true, length = 11)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 1)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamineDisposeApplicationEntity that = (ExamineDisposeApplicationEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(historyId, that.historyId) &&
                Objects.equals(registrationId, that.registrationId) &&
                Objects.equals(itemId, that.itemId) &&
                Objects.equals(itemName, that.itemName) &&
                Objects.equals(requiment, that.requiment) &&
                Objects.equals(part, that.part) &&
                Objects.equals(isEmergency, that.isEmergency) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(creatTime, that.creatTime) &&
                Objects.equals(doctorId, that.doctorId) &&
                Objects.equals(technicianDoctorId, that.technicianDoctorId) &&
                Objects.equals(resultDoctorId, that.resultDoctorId) &&
                Objects.equals(examineTime, that.examineTime) &&
                Objects.equals(result, that.result) &&
                Objects.equals(resultTime, that.resultTime) &&
                Objects.equals(state, that.state) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, historyId, registrationId, itemId, itemName, requiment, part, isEmergency, amount, creatTime, doctorId, technicianDoctorId, resultDoctorId, examineTime, result, resultTime, state, type);
    }
}
