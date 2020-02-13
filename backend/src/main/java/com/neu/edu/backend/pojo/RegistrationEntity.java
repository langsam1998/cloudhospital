package com.neu.edu.backend.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "registration", schema = "cloudhospital", catalog = "")
public class RegistrationEntity {
    private int id;
    private int medicalHistoryId;
    private String name;
    private String gender;
    private String idNumber;
    private Date birthDate;
    private int age;
    private String ageType;
    private String address;
    private Date date;
    private String morningAfternoon;
    private int departmentId;
    private int doctorId;
    private String registrationLevel;
    private String paymentType;
    private String needHistorybook;
    private Timestamp registrationTime;
    private String register;
    private String state;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "medical_history_id", nullable = false)
    public int getMedicalHistoryId() {
        return medicalHistoryId;
    }

    public void setMedicalHistoryId(int medicalHistoryId) {
        this.medicalHistoryId = medicalHistoryId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 64)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "gender", nullable = false, length = 11)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "id_number", nullable = false, length = 64)
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Basic
    @Column(name = "birth_date", nullable = false)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "age", nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Basic
    @Column(name = "age_type", nullable = false, length = 11)
    public String getAgeType() {
        return ageType;
    }

    public void setAgeType(String ageType) {
        this.ageType = ageType;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 64)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "morning_afternoon", nullable = false, length = 11)
    public String getMorningAfternoon() {
        return morningAfternoon;
    }

    public void setMorningAfternoon(String morningAfternoon) {
        this.morningAfternoon = morningAfternoon;
    }

    @Basic
    @Column(name = "department_id", nullable = false)
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "doctor_id", nullable = false)
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    @Basic
    @Column(name = "registration_level", nullable = false, length = 11)
    public String getRegistrationLevel() {
        return registrationLevel;
    }

    public void setRegistrationLevel(String registrationLevel) {
        this.registrationLevel = registrationLevel;
    }

    @Basic
    @Column(name = "payment_type", nullable = false, length = 11)
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Basic
    @Column(name = "need_historybook", nullable = false, length = 1)
    public String getNeedHistorybook() {
        return needHistorybook;
    }

    public void setNeedHistorybook(String needHistorybook) {
        this.needHistorybook = needHistorybook;
    }

    @Basic
    @Column(name = "registration_time", nullable = false)
    public Timestamp getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Timestamp registrationTime) {
        this.registrationTime = registrationTime;
    }

    @Basic
    @Column(name = "register", nullable = false, length = 11)
    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    @Basic
    @Column(name = "state", nullable = false, length = 11)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationEntity that = (RegistrationEntity) o;
        return id == that.id &&
                medicalHistoryId == that.medicalHistoryId &&
                age == that.age &&
                departmentId == that.departmentId &&
                doctorId == that.doctorId &&
                Objects.equals(name, that.name) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(idNumber, that.idNumber) &&
                Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(ageType, that.ageType) &&
                Objects.equals(address, that.address) &&
                Objects.equals(date, that.date) &&
                Objects.equals(morningAfternoon, that.morningAfternoon) &&
                Objects.equals(registrationLevel, that.registrationLevel) &&
                Objects.equals(paymentType, that.paymentType) &&
                Objects.equals(needHistorybook, that.needHistorybook) &&
                Objects.equals(registrationTime, that.registrationTime) &&
                Objects.equals(register, that.register) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, medicalHistoryId, name, gender, idNumber, birthDate, age, ageType, address, date, morningAfternoon, departmentId, doctorId, registrationLevel, paymentType, needHistorybook, registrationTime, register, state);
    }
}
