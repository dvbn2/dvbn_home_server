package com.dvbn.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 地址簿
 *
 * @TableName address_books
 */
@TableName(value = "address_books")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AddressBooks implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 收货人
     */
    private String consignee;
    /**
     * 性别 0:女，1:男
     */
    private Integer sex;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 省级区划编号
     */
    private String provinceCode;
    /**
     * 省级名称
     */
    private String provinceName;
    /**
     * 市级区划编号
     */
    private String cityCode;
    /**
     * 市级名称
     */
    private String cityName;
    /**
     * 区级区划编号
     */
    private String districtCode;
    /**
     * 区级名称
     */
    private String districtName;
    /**
     * 详细地址
     */
    private String detail;
    /**
     * 标签
     */
    private String label;
    /**
     * 默认 0 否 1是
     */
    private Integer isDefault;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}