package com.dvbn.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 预订表
 *
 * @TableName booking
 */
@TableName(value = "booking")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Booking implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 民宿id
     */
    private Long residentialId;
    /**
     * 入住日期
     */
    private LocalDateTime checkInDate;
    /**
     * 退房日期
     */
    private LocalDateTime checkOutDate;
    /**
     * 总价格
     */
    private BigDecimal totalPrice;
    /**
     * 入住人数
     */
    private Integer guestCount;
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
}