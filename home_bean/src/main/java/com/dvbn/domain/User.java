package com.dvbn.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户表
 *
 * @TableName user
 */
@TableName(value = "user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 名字
     */
    private String name;
    /**
     * 性别 0:女，1:男
     */
    private Integer sex;
    /**
     * 用户类型 0:普通用户，1:房东
     */
    private Integer userType;
    /**
     * 手机号
     */
    private String phoneNumber;
    /**
     * 用户状态 1:正常，2:禁用，3:删除
     */
    private Integer status;
    /**
     * 用户身份证号
     */
    private String idNumber;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
    /**
     * 创建人
     */
    private Long createUser;
    /**
     * 修改人
     */
    private Long updateUser;
    /**
     * 用户积分
     */
    private Integer score;

    /**
     * 头像地址
     */
    private String avatar;
}