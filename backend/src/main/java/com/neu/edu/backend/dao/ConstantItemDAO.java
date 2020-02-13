package com.neu.edu.backend.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.neu.edu.backend.pojo.ConstantItemEntity;

public interface ConstantItemDAO extends JpaRepository<ConstantItemEntity,Integer>{

    ConstantItemEntity getById(String id);
}
