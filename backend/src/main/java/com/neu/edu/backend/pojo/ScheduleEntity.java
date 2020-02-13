package com.neu.edu.backend.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "schedule", schema = "cloudhospital", catalog = "")
public class ScheduleEntity {
    private String id;
    private String departmentId;
    private String doctorId;
    private String morningAfternoon;
    private String scheduleRuleId;
    private String isDelete;
    private Date date;

    @Id
    @Column(name = "id", nullable = false, length = 11)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "department_id", nullable = false, length = 11)
    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "doctor_id", nullable = false, length = 11)
    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
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
    @Column(name = "schedule_rule_id", nullable = false, length = 11)
    public String getScheduleRuleId() {
        return scheduleRuleId;
    }

    public void setScheduleRuleId(String scheduleRuleId) {
        this.scheduleRuleId = scheduleRuleId;
    }

    @Basic
    @Column(name = "is_delete", nullable = false, length = 1)
    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleEntity that = (ScheduleEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(departmentId, that.departmentId) &&
                Objects.equals(doctorId, that.doctorId) &&
                Objects.equals(morningAfternoon, that.morningAfternoon) &&
                Objects.equals(scheduleRuleId, that.scheduleRuleId) &&
                Objects.equals(isDelete, that.isDelete) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentId, doctorId, morningAfternoon, scheduleRuleId, isDelete, date);
    }
}
