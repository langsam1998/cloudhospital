package com.neu.edu.backend.controller;
import com.neu.edu.backend.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.neu.edu.backend.pojo.RegistrationEntity;
import java.util.List;

@RestController
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;

    @CrossOrigin
    @GetMapping(value = "/api/registration")
    public List<RegistrationEntity> list() throws Exception{
        return registrationService.list();
    }

    @CrossOrigin
    @RequestMapping(value = "/api/registration/search")
    public List<RegistrationEntity> search(Integer medicalHistoryId) throws Exception{
        return registrationService.search(medicalHistoryId);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/registration/historyId")
    public Integer getHistoryId() throws Exception{
        return registrationService.getHistoryId().get(0).getMedicalHistoryId()+1;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/registration/add")
    public RegistrationEntity addOrUpdate(@RequestBody RegistrationEntity registrationEntity) throws Exception{
        registrationService.addOrUpdate(registrationEntity);
        return registrationEntity;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/registration/finished")
    public List<RegistrationEntity> finishedList(Integer doctorId) throws Exception{
        return registrationService.finishedList(doctorId);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/registration/unfinished")
    public List<RegistrationEntity> unfinishedList(Integer doctorId) throws Exception{
        return registrationService.unfinishedList(doctorId);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/registration/state")
    public RegistrationEntity changeState(Integer medicalHistoryId) throws Exception{
        RegistrationEntity registrationEntity=registrationService.search(medicalHistoryId).get(0);
        System.out.println("fuck");
        return registrationService.changeState(registrationEntity);
    }
}
