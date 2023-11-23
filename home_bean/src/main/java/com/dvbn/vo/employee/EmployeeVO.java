package com.dvbn.vo.employee;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author dvbn
 * @title: EmployeeVO
 * @createDate 2023/9/20 10:59
 */
@Data
public class EmployeeVO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 地址
     */
    private String address;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 创建人
     */
    private String createName;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 最后操作时间
     */
    private LocalDateTime endTime;
}
