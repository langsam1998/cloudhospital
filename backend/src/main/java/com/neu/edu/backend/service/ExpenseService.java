package com.neu.edu.backend.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neu.edu.backend.pojo.ExpenseEntity;
import com.neu.edu.backend.dao.ExpenseDAO;

import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    ExpenseDAO expenseDAO;

    public List<ExpenseEntity> getAll(Integer medicalHistoryId){
        return expenseDAO.getAllByMedicalHistoryId(medicalHistoryId);
    }
}
