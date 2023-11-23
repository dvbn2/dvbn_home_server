package com.dvbn.dto.user;

import lombok.Data;

/**
 * @author dvbn
 * @title: UserPageDTO
 * @createDate 2023/11/7 12:13
 */
@Data
public class UserPageDTO {
    /**
     * 页数
     */
    private Long page;
    /**
     * 每页记录数
     */
    private Long pageSize;
    /**
     * 用户状态 1:正常 2:禁用 3:删除
     */
    private Integer status;
    /**
     * 用户性别 0:女 1:男
     */
    private Integer sex;
    /**
     * 用户手机号
     */
    private String phoneNumber;
    /**
     * 用户类型 0:普通用户 1:商家
     */
    private Integer userType;
}
