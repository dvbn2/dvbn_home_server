package com.dvbn.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单明细表
 *
 * @TableName order_detail
 */
@TableName(value = "order_detail")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderDetail implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 民宿id
     */
    private Long residentialId;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 入住时间
     */
    private LocalDateTime checkInDate;
    /**
     * 退房时间
     */
    private LocalDateTime checkOutDate;
    /**
     * 入住人数
     */
    private Integer guestCount;
}