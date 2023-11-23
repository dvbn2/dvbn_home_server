package com.dvbn.dto.employee;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dvbn
 * @title: EmployeeUpdateDTO
 * @createDate 2023/9/25 9:03
 */
@Data
public class EmployeeUpdateDTO implements Serializable {

    /**
     * id
     */
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 地址
     */
    private String address;
    /**
     * 用户名
     */
    private String username;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 账号状态
     */
    private Integer status;
}
