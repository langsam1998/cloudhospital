package com.neu.edu.backend.controller;
import com.neu.edu.backend.pojo.ExpenseEntity;
import com.neu.edu.backend.service.ExpenseService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class ExpenseController {
    @Autowired
    ExpenseService expenseService;

    @CrossOrigin
    @RequestMapping(value = "/api/expense")
    public List<ExpenseEntity> getAll(Integer medicalHistoryId){
        return expenseService.getAll(medicalHistoryId);
    }

}
