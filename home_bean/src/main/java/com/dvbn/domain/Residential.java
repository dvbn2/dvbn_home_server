package com.dvbn.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 民宿表
 *
 * @TableName residential
 */
@TableName(value = "residential")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Residential implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 类型id
     */
    private Long categoryId;
    /**
     * 省级名称
     */
    private String provinceName;
    /**
     * 市级名称
     */
    private String cityName;
    /**
     * 区级名称
     */
    private String districtName;
    /**
     * 详细地址
     */
    private String detail;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 描述
     */
    private String description;
    /**
     * 房间数
     */
    private String totalRooms;
    /**
     * 可入住人数
     */
    private String guestNumber;
    /**
     * 纬度
     */
    private BigDecimal latitude;
    /**
     * 经度
     */
    private BigDecimal longitude;
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