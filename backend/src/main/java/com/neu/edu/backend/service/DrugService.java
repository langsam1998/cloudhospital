package com.neu.edu.backend.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.neu.edu.backend.pojo.DrugsEntity;
import com.neu.edu.backend.dao.DrugDAO;

import java.util.List;


@Service
public class DrugService {
    @Autowired
    DrugDAO drugDAO;

    public List<DrugsEntity> getAll(){
        Sort sort=new Sort(Sort.Direction.ASC,"id");
        return drugDAO.findAll(sort);
    }

    public DrugsEntity findById(String id){
        return drugDAO.findAllById(id);
    }
}
