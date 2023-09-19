package com.dvbn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author dvbn
 * @title: EmployeeLoginDTO
 * @createDate 2023/9/18 11:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EmployeeLoginDTO {
    private String username;
    private String password;
}
