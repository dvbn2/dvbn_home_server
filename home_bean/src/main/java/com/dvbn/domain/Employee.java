package com.dvbn.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 员工表
 *
 * @TableName employee
 */
@TableName(value = "employee")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Employee implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public static final Integer DISABLE = 0;
    public static final Integer NORMAL = 1;
    /**
     * 主键
     */
    @TableId
    private Long id;
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
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
    /**
     * 创建人id
     */
    private Long createUser;
    /**
     * 修改人id
     */
    private Long updateUser;

    /**
     * 最后操作时间
     */
    private LocalDateTime endTime;
}