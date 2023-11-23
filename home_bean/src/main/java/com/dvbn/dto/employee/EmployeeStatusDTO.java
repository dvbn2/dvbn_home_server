package com.dvbn.dto.employee;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dvbn
 * @title: EmployeeStatusDTO
 * @createDate 2023/9/21 16:05
 */
@Data
public class EmployeeStatusDTO implements Serializable {

    /**
     * id
     */
    private Long id;
    /**
     * 修改的状态
     */
    private Integer status;
}
