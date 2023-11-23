package com.dvbn.aspect;

import com.dvbn.annotation.Login;
import com.dvbn.exception.BusinessException;
import com.dvbn.utils.BaseContext;
import com.dvbn.utils.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author dvbn
 * @title: LoginAspect
 * @createDate 2023/11/22 11:35
 */
@Component
@Aspect
@Slf4j
public class LoginAspect {

    @Before("execution(* com.dvbn.controller.*.*(..))")
    public void AllLoginAspect(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();//方法签名对象
        Login isLogin = signature.getMethod().getAnnotation(Login.class);//获得方法上的注解对象
        if (isLogin != null) {
            return;
        }

        if (BaseContext.getCurrentId() == null) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        log.info("ThreadLocal对象, {}", BaseContext.getCurrentId());
    }
}
