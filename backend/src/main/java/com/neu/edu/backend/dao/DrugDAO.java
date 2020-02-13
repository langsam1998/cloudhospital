package com.neu.edu.backend.dao;
import com.neu.edu.backend.pojo.DrugsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrugDAO extends JpaRepository<DrugsEntity,Integer>{
    public DrugsEntity findAllById(String id);
}
