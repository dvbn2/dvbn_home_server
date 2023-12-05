package com.dvbn.aspect;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.dvbn.annotation.Login;
import com.dvbn.domain.Employee;
import com.dvbn.exception.BusinessException;
import com.dvbn.result.Result;
import com.dvbn.service.EmployeeService;
import com.dvbn.utils.BaseContext;
import com.dvbn.utils.ErrorCode;
import com.dvbn.vo.TokenVO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author dvbn
 * @title: LoginAspect
 * @createDate 2023/11/22 11:35
 */
@Component
@Aspect
@Slf4j
public class LoginAspect {

    /**
     * 用户请求拦截
     *
     * @param joinPoint the join point
     */
    @Before("execution(* com.dvbn.controller.*.*(..))")
    public void AllRequestAspect(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();//方法签名对象
        Login login = signature.getMethod().getAnnotation(Login.class);//获得方法上的注解对象
        // 为登录方法
        if (login != null) {
            return;
        }
        log.info("ThreadLocal对象, {}", BaseContext.getCurrentId());
        if (BaseContext.getCurrentId() == null) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
    }
}
