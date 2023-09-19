package com.dvbn.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dvbn.constant.ExceptionConstant;
import com.dvbn.constant.RedisConstant;
import com.dvbn.constant.ResultConstant;
import com.dvbn.domain.Employee;
import com.dvbn.dto.EmployeeLoginDTO;
import com.dvbn.exception.LoginException;
import com.dvbn.mapper.EmployeeMapper;
import com.dvbn.result.Result;
import com.dvbn.service.EmployeeService;
import com.dvbn.vo.TokenVo;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author dvbn
 * @description 针对表【employee(员工表)】的数据库操作Service实现
 * @createDate 2023-09-16 19:16:02
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
        implements EmployeeService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 员工登录
     *
     * @return 返回登录是否成功的信息
     */
    @Override
    public Result<TokenVo> login(EmployeeLoginDTO employeeLoginDTO) {
        String username = employeeLoginDTO.getUsername();
        String password = employeeLoginDTO.getPassword();

        // 1. 校验用户名和密码是否为空
        if ((StrUtil.isBlank(username) && StrUtil.isBlank(password))) {
            throw new LoginException(ExceptionConstant.USERNAME_OR_PASSWORD_NULL);
        }

        // 2. 查询员工是否存在
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(username != null, Employee::getUsername, username)
                .eq(password != null, Employee::getPassword, password);
        Employee employee = getOne(queryWrapper);

        // 3. 不存在返回错误信息
        if (BeanUtil.isEmpty(employee)) {
            throw new LoginException(ExceptionConstant.USERNAME_OR_PASSWORD_ERROR);
        }

        // 4. 将员工id存入redis中
        // 4.1 生成token令牌
        String token = UUID.randomUUID().toString(true); // true：取消uuid中的-

        // 4.2 存入redis
        stringRedisTemplate.opsForValue().set(RedisConstant.EMPLOYEE_LOGIN_TOKEN + token,
                employee.getId().toString(), RedisConstant.TOKEN_SURVIVE_TIME, TimeUnit.DAYS);

        // 5. 返回登录的token，让浏览器保存到请求头
        TokenVo tokenVo = new TokenVo(token, employee.getId());
        return Result.success(ResultConstant.LOGIN_SUCCESS, tokenVo);
    }
}




