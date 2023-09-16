package com.dvbn.exception;

/**
 * 业务异常
 * @author dvbn
 */
public class BaseException extends RuntimeException {

    public BaseException() {
    }

    public BaseException(String msg) {
        super(msg);
    }

}
