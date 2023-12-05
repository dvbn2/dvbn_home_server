package com.dvbn.utils;

import com.dvbn.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Objects;

/**
 * @author dvbn
 * @title: ObjectIsNullUtil
 * @createDate 2023/11/10 0:49
 */
@Slf4j
public class ObjectIsNullUtil {
    /**
     * 判断对象是否完全为空
     *
     * @param object 待检测对象
     * @return 返回检测结果
     */
    public static boolean objectCheckIsNull(Object object) {
        //定义返回结果，默认为false
        boolean flag = true;

        // 对象为null直接返回
        if (Objects.isNull(object)) {
            return true;
        }
        // 得到类对象
        Class<?> clazz = object.getClass();
        // 得到所有属性
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object fieldValue;
            try {
                fieldValue = field.get(object); //得到属性值
                Type fieldType = field.getGenericType();//得到属性类型
                String fieldName = field.getName(); // 得到属性名
                log.info("属性类型：" + fieldType + ",属性名：" + fieldName + ",属性值：" + fieldValue);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                log.error(e.getMessage(), e);
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
            if (fieldValue != null) {  //只要有一个属性值不为null 就返回false 表示对象不为null
                flag = false;
                break;
            }
        }
        return flag;
    }
}
