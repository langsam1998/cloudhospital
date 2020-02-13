package com.neu.edu.backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.neu.edu.backend.service.DepartmentService;
import com.neu.edu.backend.pojo.DepartmentEntity;

import java.util.List;


@RestController
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;


    @CrossOrigin
    @GetMapping(value = "/api/department")
    public List<DepartmentEntity> list() throws Exception{
        return departmentService.getAll();
    }
}
