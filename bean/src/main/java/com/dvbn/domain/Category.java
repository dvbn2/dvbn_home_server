package com.dvbn.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 民宿类型表
 *
 * @author dvbn
 * @TableName category
 * @Date 2023/09/16
 */
@TableName(value = "category")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Category implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 类型
     */
    private String typeName;

    /**
     * 类型描述
     */
    private String description;

    /**
     * 类型状态 0:禁用，1:起用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建人id
     */
    private Long createUser;

    /**
     * 修改人id
     */
    private Long updateUser;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}