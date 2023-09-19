package com.dvbn.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 举报表
 *
 * @author dvbn
 * @TableName report
 * @Date 2023/09/16
 */
@TableName(value = "report")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Report implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 被举报用户id
     */
    private Long reportedUserId;

    /**
     * 被举报民宿id
     */
    private Long reportedResidentialId;

    /**
     * 举报类型
     */
    private String reportType;

    /**
     * 举报内容描述
     */
    private String description;

    /**
     * 举报状态 0:待处理，1:已处理
     */
    private Integer status;

    /**
     * 举报时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 举报人id
     */
    private Long createUser;

    /**
     * 修改人id
     */
    private Long updateUser;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}