package com.neu.edu.backend.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.neu.edu.backend.pojo.ExpenseEntity;

import java.util.List;

public interface ExpenseDAO extends JpaRepository<ExpenseEntity,Integer> {
    public List<ExpenseEntity> getAllByMedicalHistoryId(Integer medicalHistoryId);
}
