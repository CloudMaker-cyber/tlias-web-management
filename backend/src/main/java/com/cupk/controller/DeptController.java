package com.cupk.controller;

import com.cupk.pojo.Dept;
import com.cupk.pojo.Result;
import com.cupk.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result list() {
        System.out.println("查询所有部门");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }
}
