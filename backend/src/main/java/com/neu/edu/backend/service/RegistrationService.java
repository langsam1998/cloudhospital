package com.neu.edu.backend.service;
import com.neu.edu.backend.dao.RegistrationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.neu.edu.backend.pojo.RegistrationEntity;

import java.util.List;


@Service
public class RegistrationService {
    @Autowired
    RegistrationDAO registrationDAO;

    public List<RegistrationEntity> list(){
        Sort sort=new Sort(Sort.Direction.ASC,"id");
        return registrationDAO.findAll(sort);
    }

    public List<RegistrationEntity> search(Integer medicalHistoryId){
        return registrationDAO.getByMedicalHistoryId(medicalHistoryId);
    }

    public List<RegistrationEntity> getHistoryId(){
        Sort sort=new Sort(Sort.Direction.DESC,"medicalHistoryId");
        return registrationDAO.findAll(sort);
    }

    public void addOrUpdate(RegistrationEntity registrationEntity){
        registrationDAO.save(registrationEntity);
    }

    public List<RegistrationEntity> finishedList(Integer doctorId){
        return registrationDAO.getAllByStateAndDoctorId("2",doctorId);
    }

    public List<RegistrationEntity> unfinishedList(Integer doctorId){
        return registrationDAO.getAllByStateAndDoctorId("3",doctorId);
    }

    public RegistrationEntity changeState(RegistrationEntity registrationEntity){
        registrationEntity.setState("2");
        registrationDAO.save(registrationEntity);
        return registrationEntity;
    }
}
