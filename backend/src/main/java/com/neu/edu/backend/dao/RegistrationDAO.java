package com.neu.edu.backend.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.neu.edu.backend.pojo.RegistrationEntity;

import java.util.List;

public interface RegistrationDAO extends JpaRepository<RegistrationEntity,Integer>{

    List<RegistrationEntity> getByMedicalHistoryId(Integer medicalHistoryId);
    List<RegistrationEntity> getAllByState(String state);
    List<RegistrationEntity> getAllByStateAndDoctorId(String state,Integer doctorId);

}
