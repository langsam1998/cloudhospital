package com.neu.edu.backend.controller;


import com.neu.edu.backend.service.ConstantItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConstantItemController {
    @Autowired
    ConstantItemService constantItemService;

    @CrossOrigin
    @RequestMapping(value = "/api/registrationFee")
    public String getFee(String id) throws Exception{
        return constantItemService.getFee(id);
    }
}
