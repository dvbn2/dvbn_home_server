package com.dvbn.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 订单表
 *
 * @author dvbn
 * @TableName order
 * @Date 2023/09/16
 */
@TableName(value = "order")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Order implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 订单金额
     */
    private BigDecimal totalPrice;

    /**
     * 支付方式 0:支付宝，1:微信，2:银行卡
     */
    private Integer paymentType;

    /**
     * 订单状态 0:待支付，1:已支付，2:已完成，3:已取消
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
     * 创建用户id
     */
    private Long createUser;

    /**
     * 修改用户id
     */
    private Long updateUser;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}