package com.dvbn.dto.employee;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dvbn
 * @title: EmployeeSetPwdDTO
 * @createDate 2023/9/27 8:59
 */
@Data
public class EmployeeSetPwdDTO implements Serializable {

    /**
     * 旧密码
     */
    private String OldPassword;
    /**
     * 新密码
     */
    private String NewPassword;
}
