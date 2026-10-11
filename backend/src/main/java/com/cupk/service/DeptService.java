package com.cupk.service;

import com.cupk.pojo.Dept;

import java.util.List;

public interface DeptService {

    /**
     * 查询所有部门
     * @return 部门列表
     */
    List<Dept> findAll();

    /**
     * 根据id删除部门
     * @param id 部门id
     */
    void deleteById(Integer id);

    /**
     * 新增部门
     * @param dept 部门
     */
    void add(Dept dept);

    /**
     * 根据id查询部门
     * @param id 部门id
     * @return 部门
     */
    Dept getById(Integer id);

    /**
     * 修改部门
     * @param dept 部门
     */
    void update(Dept dept);
}
