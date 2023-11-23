package com.dvbn.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 评论表
 *
 * @TableName reviews
 */
@TableName(value = "reviews")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Reviews implements Serializable {
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
     * 评分
     */
    private String rating;
    /**
     * 评论内容
     */
    private String comment;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
    /**
     * 创建人id
     */
    private Long createUser;
    /**
     * 修改人id
     */
    private Long updateUser;
}