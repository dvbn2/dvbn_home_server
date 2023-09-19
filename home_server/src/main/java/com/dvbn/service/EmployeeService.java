package com.dvbn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dvbn.domain.Employee;
import com.dvbn.dto.EmployeeLoginDTO;
import com.dvbn.result.Result;
import com.dvbn.vo.TokenVo;

/**
 * @author dvbn
 * @description 针对表【employee(员工表)】的数据库操作Service
 * @createDate 2023-09-16 19:16:02
 */
public interface EmployeeService extends IService<Employee> {

    /**
     * 员工登录
     * @return 返回登录是否成功的信息
     */
    Result<TokenVo> login(EmployeeLoginDTO employeeLoginDTO);
}
