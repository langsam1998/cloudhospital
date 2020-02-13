package com.neu.edu.backend.service;

import com.neu.edu.backend.dao.ConstantItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ConstantItemService {
    @Autowired
    ConstantItemDAO constantItemDAO;


    public String getFee(String id){
        return constantItemDAO.getById(id).getPrice();
    }
}
