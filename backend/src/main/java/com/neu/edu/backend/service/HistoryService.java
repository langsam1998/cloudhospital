package com.neu.edu.backend.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neu.edu.backend.dao.HistoryDao;
import com.neu.edu.backend.pojo.HistoryEntity;


@Service
public class HistoryService {
    @Autowired
    HistoryDao historyDao;

    public void addOrUpdate(HistoryEntity historyEntity){historyDao.save(historyEntity);}
}
