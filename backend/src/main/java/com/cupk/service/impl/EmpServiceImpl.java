package com.cupk.service.impl;

import com.cupk.mapper.EmpMapper;
import com.cupk.pojo.Emp;
import com.cupk.pojo.PageResult;
import com.cupk.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 由于员工工作经历是员工的附属信息，所以不再单独处理，统一放到员工信息中处理
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        //1。调用mapper接口查询总人数
        Long total = empMapper.count();
        //2。调用mapper接口查询当前页数据
        Integer start = (page - 1) * pageSize;
        List<Emp> rows = empMapper.list(start, pageSize);
        //3，封装结果PageResult
        return new PageResult<Emp>(total, rows);
    }
}
