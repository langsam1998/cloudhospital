package com.neu.edu.backend.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.neu.edu.backend.pojo.HistoryEntity;

public interface HistoryDao extends JpaRepository<HistoryEntity,Integer>{

}
