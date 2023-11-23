package com.dvbn.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author dvbn
 * @title: Login
 * @createDate 2023/11/22 12:07
 */
@Target(ElementType.METHOD) // 表示这个注解只能加在方法上
@Retention(RetentionPolicy.RUNTIME)
public @interface Login {
    String value() default "";
}
