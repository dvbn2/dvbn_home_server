package com.dvbn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dvbn.domain.Employee;
import com.dvbn.dto.employee.*;
import com.dvbn.result.PageResult;
import com.dvbn.result.Result;
import com.dvbn.vo.employee.EmployeeInfoVO;
import com.dvbn.vo.employee.EmployeeVO;
import com.dvbn.vo.TokenVO;

import javax.servlet.http.HttpServletRequest;

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
    Result<TokenVO> employeeLogin(EmployeeLoginDTO employeeLoginDTO, HttpServletRequest request);

    /**
     * 添加员工
     *
     * @param employeeAddDTO 员工数据对象
     * @return 返回添加结果
     */
    Result<String> addEmployee(EmployeeAddDTO employeeAddDTO);

    /**
     * 员工信息分页查询
     *
     * @param employeePageDTO 查询参数，page、pageSize、name
     * @return 返回分页查询数据和记录数
     */
    Result<PageResult<EmployeeVO>> getEmployeePage(EmployeePageDTO employeePageDTO);

    /**
     * 根据id查询
     * @param id 员工id
     * @return 返回员工详细信息
     */
    Result<EmployeeInfoVO> getEmployeeById(Long id);

    /**
     * 修改员工账号状态
     * @param employee 员工id和要修改的状态
     * @return 返回操作的信息
     */
    Result<String> setEmployeeStatus(Employee employee);

    /**
     * 修改员工信息
     * @param employeeUpdateDTO 员工修改的字段对象
     * @return 返回操作结果
     */
    Result<String> updateEmployee(EmployeeUpdateDTO employeeUpdateDTO);

    /**
     * 员工密码修改
     * @param employeeSetPwdDTO 员工id、员工新旧密码
     * @return 返回修改是否成功
     */
    Result<String> updateEmployeePassword(EmployeeSetPwdDTO employeeSetPwdDTO);

    /**
     * 退出登录
     * @param token 请求token
     * @return 返回退出是否成功
     */
    Result<String> employeeLogout(String token);
}
