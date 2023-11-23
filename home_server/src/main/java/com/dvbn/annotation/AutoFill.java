package com.dvbn.annotation;


import com.dvbn.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解，用于公共字段填充
 * @author dvbn
 */
@Target(ElementType.METHOD) // 表示这个注解只能加在方法上
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {

    // 数据库操作类型，insert update
    OperationType value();
}
