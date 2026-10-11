package com.cupk.service;

import com.cupk.pojo.Dept;

import java.util.List;

public interface DeptService {

    /**
     * 查询所有部门
     * @return 部门列表
     */
    List<Dept> findAll();
}
