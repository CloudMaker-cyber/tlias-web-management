package com.cupk.service;

import com.cupk.pojo.EmpLog;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface EmpLogService {


    public void insertLog(EmpLog empLog);

}
