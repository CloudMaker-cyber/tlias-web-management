package com.cupk.exception;

import com.cupk.pojo.Result;
import lombok.extern.slf4j.Slf4j;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 全局异常处理
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    // 全局异常处理方法
    @ExceptionHandler
    public Result handleException(Exception e) {
        log.error("程序出错了: {}", e.getMessage());
        return Result.error("程序出错了: 请联系管理员" );
    }

    @ExceptionHandler
    public Result handleException(DuplicateKeyException e) {
        log.error("业务异常: {}", e);
        String message = e.getMessage();
        int i = message.indexOf("Duplicate entry");
        String errMsg = message.substring(i);
        String[] arr = errMsg.split(" ");
        return Result.error(arr[2] + "已存在");
    }
}
