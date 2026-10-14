package com.cupk.controller;

import com.cupk.pojo.Emp;
import com.cupk.pojo.EmpQueryParam;
import com.cupk.pojo.PageResult;
import com.cupk.pojo.Result;
import com.cupk.service.impl.EmpServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpServiceImpl empService;
    /**
     * 分页查询
     */
    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("分页查询{} ", empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    //新增员工
    @PostMapping
    public Result add(@RequestBody Emp emp) {//RequestBody注解表示将请求体中的json数据转换为Emp对象
        log.info("新增员工{} ", emp);
        empService.save(emp);
        return Result.success();
    }
}
