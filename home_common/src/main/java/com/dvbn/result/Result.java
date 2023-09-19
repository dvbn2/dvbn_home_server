package com.dvbn.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 后端统一返回结果
 * @author dvbn
 * @param <T>
 */
@Data
public class Result<T> implements Serializable {


    private static final Integer SUCCESS = 200;
    private static final Integer ERROR = 500;
    /**
     * 编码：1成功，0和其它数字为失败
     */
    private Integer code;
    /**
     * 错误信息
     */
    private String msg;
    /**
     * 数据
     */
    private T data;

    public static <T> Result<T> success(String msg) {
        Result<T> result = new Result<>();
        result.msg = msg;
        result.code = SUCCESS;
        return result;
    }

    public static <T> Result<T> success(String msg, T object) {
        Result<T> result = new Result<>();
        result.msg = msg;
        result.data = object;
        result.code = SUCCESS;
        return result;
    }

    public static <T> Result<T> error(String msg, Integer code) {
        Result<T> result = new Result<>();
        result.msg = msg;
        result.code = code;
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.msg = msg;
        result.code = ERROR;
        return result;
    }

}
