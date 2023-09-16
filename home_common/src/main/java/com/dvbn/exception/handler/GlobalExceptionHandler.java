package com.dvbn.exception.handler;

import com.dvbn.exception.BaseException;
import com.dvbn.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author dvbn
 * @title: GlobalExceptionHandler
 * @createDate 2023/9/16 20:56
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     *
     * @param exception 异常类型
     * @return 异常信息
     */
    @ExceptionHandler
    public Result<?> exceptionHandler(BaseException exception) {
        log.error("异常信息：{}", exception.getMessage());
        return Result.error(exception.getMessage());
    }
}
