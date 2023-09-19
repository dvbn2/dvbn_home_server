package com.dvbn.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务异常
 * @author dvbn
 */
public class BaseException extends RuntimeException {

    /**
     * 状态码
     */
    private Integer code;
    public BaseException() {
    }

    public BaseException(String msg) {
        super(msg);
    }

    public BaseException(String msg, Integer code) {
        super(msg);
        this.code = code;
    }
    public Integer getCode() {
        return code;
    }
}
