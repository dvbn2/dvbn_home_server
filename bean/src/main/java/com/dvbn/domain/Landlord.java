package com.dvbn.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 房东表
 *
 * @author dvbn
 * @TableName landlord
 * @Date 2023/09/16
 */
@TableName(value = "landlord")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Landlord implements Serializable {
    /**
     * 直接使用用户id
     */
    @TableId
    private Long id;

    /**
     * 简介
     */
    private String intro;

    /**
     * 银行账户
     */
    private String bankAccount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}