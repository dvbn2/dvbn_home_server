package com.dvbn.dto.employee;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dvbn
 * @title: EmployeePageDTO
 * @createDate 2023/9/20 10:36
 */
@Data
public class EmployeePageDTO implements Serializable {

    private Long page;
    private Long pageSize;
    private String name;
    private static final long serialVersionUID = 1L;
}
