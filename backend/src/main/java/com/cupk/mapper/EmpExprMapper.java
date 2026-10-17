package com.cupk.mapper;

import com.cupk.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    /**
     * 批量插入员工工作经历信息
     * @param exprList
     */
    void insertBatch(List<EmpExpr> exprList);

    /**
     * 根据员工ID删除工作经历信息
     */
    void deleteByEmpIds(List<Integer> empIds);
}
