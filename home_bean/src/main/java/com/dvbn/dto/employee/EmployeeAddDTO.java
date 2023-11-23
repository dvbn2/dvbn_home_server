package com.dvbn.dto.employee;

import lombok.Data;

/**
 * @author dvbn
 * @title: EmployeeAddDTO
 * @createDate 2023/11/18 1:00
 */
@Data
public class EmployeeAddDTO {
    /**
     * 管理员用户名
     */
    private String username;
    /**
     * 管理员密码
     */
    private String password;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 电子邮件
     */
    private String email;
    /**
     * 性别 0:女，1:男
     */
    private Integer sex;
    /**
     * 地址
     */
    private String address;
    /**
     * 名字
     */
    private String name;
    /**
     * 状态 0:禁用，1:启用
     */
    private Integer status;
}
