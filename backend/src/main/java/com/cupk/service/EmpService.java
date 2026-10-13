package com.cupk.service;

import com.cupk.pojo.Emp;
import com.cupk.pojo.EmpQueryParam;
import com.cupk.pojo.PageResult;

import java.time.LocalDate;

public interface EmpService {
    /**
     * 分页查询员工信息
     *
     * @param page
     * @param pageSize
     *
     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);
}
