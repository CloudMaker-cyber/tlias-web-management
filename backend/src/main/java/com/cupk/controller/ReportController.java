package com.cupk.controller;

import com.cupk.pojo.JobOption;
import com.cupk.pojo.Result;
import com.cupk.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/report")
@Slf4j
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 职位数量统计
     */
    @GetMapping("/empJobData")
    public Result getReport() {
        log.info("统计各职位员工数量");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    /**
     * 性别数量统计
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData() {
        log.info("统计员工性别信息");
        List<Map<String, Object>> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }
}
