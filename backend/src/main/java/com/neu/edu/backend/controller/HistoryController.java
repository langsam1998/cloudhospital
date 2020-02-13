package com.neu.edu.backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.neu.edu.backend.service.HistoryService;
import com.neu.edu.backend.pojo.HistoryEntity;

@RestController
public class HistoryController {
    @Autowired
    HistoryService historyService;


    @CrossOrigin
    @RequestMapping(value = "/api/history")
    public HistoryEntity addOrUpdate(@RequestBody HistoryEntity historyEntity) throws Exception{
        historyService.addOrUpdate(historyEntity);
        return historyEntity;
    }
}
