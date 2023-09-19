package com.dvbn.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 收藏表
 *
 * @author dvbn
 * @TableName favorites
 * @Date 2023/09/16
 */
@TableName(value = "favorites")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Favorites implements Serializable {
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