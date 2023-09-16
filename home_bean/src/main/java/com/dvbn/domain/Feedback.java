package com.dvbn.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 反馈表
 *
 * @author dvbn
 * @TableName feedback
 * @Date 2023/09/16
 */
@TableName(value = "feedback")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Feedback implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 反馈内容
     */
    private String message;

    /**
     * 反馈类型
     */
    private String feedbackType;

    /**
     * 反馈状态 0:待处理，1:已处理
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
     * 反馈用户id
     */
    private Long createUser;

    /**
     * 修改人id
     */
    private Long updateUser;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}