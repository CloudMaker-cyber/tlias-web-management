package com.cupk.service;

import com.cupk.pojo.Emp;
import com.cupk.pojo.EmpQueryParam;
import com.cupk.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    /**
     * 分页查询员工信息
     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    /**
     * 添加员工信息
     */
    void save(Emp emp);

    /**
     * 根据id批量删除员工信息
     */
    void delete(List<Integer> ids);

    /**
     * 根据id获取员工信息
     */
    Emp getInfo(Integer id);

    /**
     * 修改员工信息
     */
    void update(Emp emp);
}
