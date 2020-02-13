package com.neu.edu.backend.service;


import com.neu.edu.backend.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neu.edu.backend.pojo.UserEntity;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public boolean isExist(String username) {
        UserEntity user = getByName(username);
        return null!=user;
    }

    public UserEntity getByName(String username) {
        return userDAO.findByUsername(username);
    }

    public UserEntity get(String username, String password){
        return userDAO.getByUsernameAndPassword(username, password);
    }

    public List<UserEntity> getAll(){
        return userDAO.findAll();
    }

    public List<UserEntity> getByDepAndReg(String departmentId,String registrationLevel){
        return userDAO.getAllByDepartmentIdAndRegistrationLevel(departmentId,registrationLevel);
    }
}
