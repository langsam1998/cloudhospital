package com.neu.edu.backend.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.neu.edu.backend.pojo.UserEntity;
import java.util.List;


public interface UserDAO extends JpaRepository<UserEntity,Integer>
{
    UserEntity findByUsername(String username);
    UserEntity getByUsernameAndPassword(String username,String password);
    List<UserEntity> getAllByDepartmentIdAndRegistrationLevel(String departmentId,String registrationLevel);
}
