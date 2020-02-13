package com.neu.edu.backend.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.neu.edu.backend.dao.DepartmentDAO;
import com.neu.edu.backend.pojo.DepartmentEntity;
import java.util.List;


@Service
public class DepartmentService {
    @Autowired
    DepartmentDAO departmentDAO;

    public List<DepartmentEntity> getAll(){
        Sort sort=new Sort(Sort.Direction.ASC,"id");
        return departmentDAO.findAll(sort);
    }
}
