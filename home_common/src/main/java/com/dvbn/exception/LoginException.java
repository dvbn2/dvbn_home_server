package com.dvbn.exception;

/**
 * @author dvbn
 * @title: LoginException
 * @createDate 2023/9/18 11:20
 */
public class LoginException extends BaseException {

    public LoginException(String message) {
        super(message);
    }
    public LoginException(String message, Integer code) {
        super(message, code);
    }
}
