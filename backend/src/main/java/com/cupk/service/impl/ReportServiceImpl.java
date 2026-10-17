package com.cupk.service.impl;

import com.cupk.mapper.EmpMapper;
import com.cupk.pojo.JobOption;
import com.cupk.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public JobOption getEmpJobData() {
        List<Map<String, Object>> list = empMapper.countEmpJobData();
        // 流处理：提取所有map中的pos字段，组成岗位名称集合（图表X轴）
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        // 流处理：提取所有map中的num字段，组成岗位人数集合（图表Y轴）
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();
        return new JobOption(jobList, dataList);

    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }
}
