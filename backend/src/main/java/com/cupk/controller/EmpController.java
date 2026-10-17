package com.cupk.controller;

import com.cupk.pojo.Emp;
import com.cupk.pojo.EmpQueryParam;
import com.cupk.pojo.PageResult;
import com.cupk.pojo.Result;
import com.cupk.service.EmpService;
import com.cupk.service.impl.EmpServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;
    /**
     * 分页查询
     */
    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("分页查询{} ", empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    /**新增员工
     */
    @PostMapping
    public Result add(@RequestBody Emp emp) {//RequestBody注解表示将请求体中的json数据转换为Emp对象
        log.info("新增员工{} ", emp);
        empService.save(emp);
        return Result.success();
    }

    /**删除员工
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("根据id批量删除员工{} ", ids);
        empService.delete(ids);
        return Result.success();
    }

    /**根据id查询员工
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("根据id查询员工{} ", id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }

    /**修改员工
     */
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("修改员工{} ", emp);
        empService.update(emp);
        return Result.success();
    }
}
