package com.dvbn.vo.user;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author dvbn
 * @title: UserPageVO
 * @createDate 2023/11/7 12:16
 */
@Data
public class UserVO {
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
     * 电子邮箱
     */
    private String email;
    /**
     * 性别 0:女，1:男
     */
    private Integer sex;
    /**
     * 总消费
     */
    private BigDecimal consumption;
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
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
    /**
     * 用户积分
     */
    private Integer score;
}
