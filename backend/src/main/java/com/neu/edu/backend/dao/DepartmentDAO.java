package com.neu.edu.backend.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.neu.edu.backend.pojo.DepartmentEntity;

public interface DepartmentDAO extends JpaRepository<DepartmentEntity,Integer>{
}
