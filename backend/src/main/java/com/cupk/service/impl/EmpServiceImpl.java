package com.cupk.service.impl;

import com.cupk.mapper.EmpMapper;
import com.cupk.pojo.Emp;
import com.cupk.pojo.EmpQueryParam;
import com.cupk.pojo.PageResult;
import com.cupk.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * 由于员工工作经历是员工的附属信息，所以不再单独处理，统一放到员工信息中处理
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    //--------------------原始方法--------------------//
//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize) {
//        //1。调用mapper接口查询总人数
//        Long total = empMapper.count();
//        //2。调用mapper接口查询当前页数据
//        Integer start = (page - 1) * pageSize;
//        List<Emp> rows = empMapper.list(start, pageSize);
//        //3，封装结果PageResult
//        return new PageResult<Emp>(total, rows);
//    }

    //--------------------PageHelper分页方法--------------------//
    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        //1。设置分页参数
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        //2。执行查询
        List<Emp> empList = empMapper.list(empQueryParam);
        Page<Emp> p = (Page<Emp>) empList;
        //3，返回查询结果并封装
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }
}
