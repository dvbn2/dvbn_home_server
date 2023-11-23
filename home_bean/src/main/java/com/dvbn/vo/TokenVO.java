package com.dvbn.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author dvbn
 * @title: TokenVo
 * @createDate 2023/9/18 22:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TokenVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 登录令牌
     */
    private String token;
    /**
     * id
     */
    private Long id;
}
