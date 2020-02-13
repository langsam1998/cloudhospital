package com.neu.edu.backend.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "department", schema = "cloudhospital", catalog = "")
public class DepartmentEntity {
    private String id;
    private String code;
    private String name;
    private String categoryId;
    private String isDelete;

    @Id
    @Column(name = "id", nullable = false, length = 11)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "code", nullable = false, length = 64)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    @Column(name = "category_id", nullable = false, length = 11)
    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
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
        DepartmentEntity that = (DepartmentEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(code, that.code) &&
                Objects.equals(name, that.name) &&
                Objects.equals(categoryId, that.categoryId) &&
                Objects.equals(isDelete, that.isDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, categoryId, isDelete);
    }
}
