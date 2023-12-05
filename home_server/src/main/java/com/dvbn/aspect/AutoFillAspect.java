package com.dvbn.aspect;

import com.dvbn.annotation.AutoFill;
import com.dvbn.domain.Employee;
import com.dvbn.enumeration.OperationType;
import com.dvbn.mapper.EmployeeMapper;
import com.dvbn.utils.BaseContext;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

import static com.dvbn.constant.AutoFillConstant.*;

/**
 * 自定义切面，实现公共字段自动填充
 *
 * @author dvbn
 */
@Slf4j
@Aspect
@Component
public class AutoFillAspect {

    /**
     * 前置通知，为公共字段赋值
     */
    @Before("execution(* com.dvbn.mapper.*.*(..)) && @annotation(com.dvbn.annotation.AutoFill)")
    public void autoFill(JoinPoint joinPoint) {
        log.info("AutoFillAspect...");
        //获取到当前被拦藏的方法上:的数据库操作类型
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();//方法签名对象
        AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class);//获得方法上的注解对象
        OperationType operationType = autoFill.value();//获得数据库操作类型

        //获取到当前被拦做的方法的参数--实体对象
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            return;
        }

        // 获取参数列表的第一个参数
        Object entity = args[0];

        //准务赋值的数据
        LocalDateTime now = LocalDateTime.now();
        Long currentId = BaseContext.getCurrentId();

        //根据当前不同的操作类型。为对应的属性道过反射来赋值
        if (operationType == OperationType.INSERT) {
            try {
                // 获取对象方法
                Method createTime = entity.getClass().getDeclaredMethod(SET_CREATE_TIME, LocalDateTime.class);
                Method updateTime = entity.getClass().getDeclaredMethod(SET_UPDATE_TIME, LocalDateTime.class);
                Method createUser = entity.getClass().getDeclaredMethod(SET_CREATE_USER, Long.class);
                Method updateUser = entity.getClass().getDeclaredMethod(SET_UPDATE_USER, Long.class);

                // 通过反射赋值
                createTime.invoke(entity, now);
                updateTime.invoke(entity, now);
                createUser.invoke(entity, currentId);
                updateUser.invoke(entity, currentId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (operationType == OperationType.UPDATE) {
            try {
                // 获取对象方法
                Method updateTime = entity.getClass().getDeclaredMethod(SET_UPDATE_TIME, LocalDateTime.class);
                Method updateUser = entity.getClass().getDeclaredMethod(SET_UPDATE_USER, Long.class);

                // 通过反射赋值
                updateTime.invoke(entity, now);
                updateUser.invoke(entity, currentId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
