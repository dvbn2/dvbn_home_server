package com.dvbn.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dvbn
 * @title: DeleteDataDTO
 * @createDate 2023/11/23 12:11
 */
@Data
public class DeleteDataDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 根据id删除数据
     */
    private long id;
}
