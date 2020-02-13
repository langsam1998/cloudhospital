package com.neu.edu.backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.neu.edu.backend.service.DrugService;
import com.neu.edu.backend.pojo.DrugsEntity;

import java.util.List;

@RestController
public class DrugController {

    @Autowired
    DrugService drugService;

    @CrossOrigin
    @RequestMapping(value = "/api/drugs")
    public List<DrugsEntity> getAll(){
        return drugService.getAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/api/drug")
    public DrugsEntity findById(String id){
        return drugService.findById(id);
    }
}
