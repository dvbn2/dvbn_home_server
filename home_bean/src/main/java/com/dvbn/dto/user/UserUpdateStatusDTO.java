package com.dvbn.dto.user;

import lombok.Data;

/**
 * @author dvbn
 * @title: UserDTO
 * @createDate 2023/11/9 0:13
 */
@Data
public class UserUpdateStatusDTO {
    /**
     * 主键
     */
    private Long id;
    /**
     * 用户状态 1:正常，2:禁用，3:删除
     */
    private Integer status;
}
