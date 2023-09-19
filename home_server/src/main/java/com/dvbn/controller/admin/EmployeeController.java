package com.dvbn.controller.admin;

import com.dvbn.dto.EmployeeLoginDTO;
import com.dvbn.result.Result;
import com.dvbn.service.EmployeeService;
import com.dvbn.vo.TokenVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    public Result<TokenVo> login(@RequestBody EmployeeLoginDTO employeeLoginDTO) {
        Result<TokenVo> result = employeeService.login(employeeLoginDTO);
        log.info("result======>{}", result);
        return result;
    }
}
