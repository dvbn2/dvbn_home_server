package com.dvbn.controller;

import com.dvbn.annotation.Login;
import com.dvbn.domain.Employee;
import com.dvbn.dto.employee.*;
import com.dvbn.result.PageResult;
import com.dvbn.result.Result;
import com.dvbn.service.EmployeeService;
import com.dvbn.vo.TokenVO;
import com.dvbn.vo.employee.EmployeeInfoVO;
import com.dvbn.vo.employee.EmployeeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author dvbn
 * @title: EmployeeController
 * @createDate 2023/9/18 11:08
 */
@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    /**
     * 员工登录
     *
     * @return 返回登录是否成功的信息
     */
    @PostMapping("/login")
    @Login("admin")
    public Result<TokenVO> employeeLogin(@RequestBody EmployeeLoginDTO employeeLoginDTO, HttpServletRequest request) {

        Result<TokenVO> tokenVOResult = employeeService.employeeLogin(employeeLoginDTO, request);
        log.info("result======>{}", tokenVOResult);
        return tokenVOResult;
    }

    /**
     * 添加员工
     *
     * @param employeeAddDTO 员工数据对象
     * @return 返回添加结果
     */
    @PostMapping("/add")
    public Result<String> addEmployee(@RequestBody EmployeeAddDTO employeeAddDTO) {
        return employeeService.addEmployee(employeeAddDTO);
    }

    /**
     * 员工信息分页查询
     *
     * @param employeePageDTO 查询参数，page、pageSize、name
     * @return 返回分页查询数据和记录数
     */
    @GetMapping("/page")
    public Result<PageResult<EmployeeVO>> getEmployeePage(EmployeePageDTO employeePageDTO) {
        return employeeService.getEmployeePage(employeePageDTO);
    }

    /**
     * 根据id查询
     *
     * @param id 员工id
     * @return 返回员工详细信息
     */
    @GetMapping("/one")
    public Result<EmployeeInfoVO> getEmployeeById(Long id) {
        return employeeService.getEmployeeById(id);
    }

    /**
     * 修改员工账号状态
     *
     * @param employee 员工id和要修改的状态
     * @return 返回操作的信息
     */
    @PutMapping("/status")
    public Result<String> setEmployeeStatus(@RequestBody Employee employee) {
        return employeeService.setEmployeeStatus(employee);
    }

    /**
     * 修改员工信息
     *
     * @param employeeUpdateDTO 员工修改的字段对象
     * @return 返回操作结果
     */
    @PutMapping
    public Result<String> updateEmployee(@RequestBody EmployeeUpdateDTO employeeUpdateDTO) {
        return employeeService.updateEmployee(employeeUpdateDTO);
    }

    /**
     * 员工密码修改
     *
     * @param employeeSetPwdDTO 员工id、员工新旧密码
     * @return 返回修改是否成功
     */
    @PostMapping("/password")
    public Result<String> updateEmployeePassword(@RequestBody EmployeeSetPwdDTO employeeSetPwdDTO) {
        return employeeService.updateEmployeePassword(employeeSetPwdDTO);
    }

    /**
     * 退出登录
     *
     * @param request 获取请求token
     * @return 返回退出是否成功
     */
    @PostMapping("/logout")
    public Result<String> employeeLogout(HttpServletRequest request) {
        String token = request.getHeader("Token");
        return employeeService.employeeLogout(token);
    }
}
