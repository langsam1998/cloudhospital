package com.neu.edu.backend.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "cloudhospital", catalog = "")
public class UserEntity {
    private int id;
    private String username;
    private String password;
    private String realName;
    private String categoryId;
    private String titleId;
    private String isSchedule;
    private String departmentId;
    private String registrationLevel;
    private String isDelete;
    private int authority;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 64)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 64)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "real_name", nullable = false, length = 64)
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Basic
    @Column(name = "category_id", nullable = false, length = 11)
    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "title_id", nullable = false, length = 11)
    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    @Basic
    @Column(name = "is_schedule", nullable = false, length = 1)
    public String getIsSchedule() {
        return isSchedule;
    }

    public void setIsSchedule(String isSchedule) {
        this.isSchedule = isSchedule;
    }

    @Basic
    @Column(name = "departmentId", nullable = false, length = 11)
    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "registrationLevel", nullable = false, length = 11)
    public String getRegistrationLevel() {
        return registrationLevel;
    }

    public void setRegistrationLevel(String registrationLevel) {
        this.registrationLevel = registrationLevel;
    }

    @Basic
    @Column(name = "is_delete", nullable = false, length = 1)
    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(realName, that.realName) &&
                Objects.equals(categoryId, that.categoryId) &&
                Objects.equals(titleId, that.titleId) &&
                Objects.equals(isSchedule, that.isSchedule) &&
                Objects.equals(departmentId, that.departmentId) &&
                Objects.equals(registrationLevel, that.registrationLevel) &&
                Objects.equals(isDelete, that.isDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, realName, categoryId, titleId, isSchedule, departmentId, registrationLevel, isDelete);
    }

    @Basic
    @Column(name = "authority", nullable = false)
    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }
}
