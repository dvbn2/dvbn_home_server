package com.dvbn.dto.employee;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author dvbn
 * @title: EmployeeLoginDTO
 * @createDate 2023/9/18 11:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeLoginDTO implements Serializable {
    private String username;
    private String password;
    private static final long serialVersionUID = 1L;
}
