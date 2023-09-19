package com.dvbn.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author dvbn
 * @title: TokenVo
 * @createDate 2023/9/18 22:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TokenVo {
    /**
     * 登录令牌
     */
    private String token;
    /**
     * id
     */
    private Long id;
}
