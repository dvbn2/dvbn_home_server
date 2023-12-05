package com.dvbn.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dvbn.domain.Employee;
import com.dvbn.dto.employee.*;
import com.dvbn.exception.BusinessException;
import com.dvbn.utils.ObjectIsNullUtil;
import com.dvbn.utils.ThrowUtils;
import com.dvbn.mapper.EmployeeMapper;
import com.dvbn.result.PageResult;
import com.dvbn.result.Result;
import com.dvbn.service.EmployeeService;
import com.dvbn.utils.BaseContext;
import com.dvbn.utils.ErrorCode;
import com.dvbn.vo.employee.EmployeeInfoVO;
import com.dvbn.vo.employee.EmployeeVO;
import com.dvbn.vo.TokenVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.BindingException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.dvbn.constant.RedisConstant.LOGIN_TOKEN_KEY;
import static com.dvbn.constant.RedisConstant.LOGIN_TOKEN_TTL;

/**
 * @author dvbn
 * @description 针对表【employee(员工表)】的数据库操作Service实现
 * @createDate 2023-09-16 19:16:02
 */
@Service
@Slf4j
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
        implements EmployeeService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private EmployeeMapper employeeMapper;

    /**
     * 员工登录
     *
     * @return 返回登录是否成功的信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<TokenVO> employeeLogin(EmployeeLoginDTO employeeLoginDTO, HttpServletRequest request) {
        ThrowUtils.throwIf(ObjectIsNullUtil.objectCheckIsNull(employeeLoginDTO), ErrorCode.PARAMS_ERROR);

        String username = employeeLoginDTO.getUsername();
        String password = employeeLoginDTO.getPassword();

        // 1. 校验用户名和密码是否为空
        if ((StrUtil.isBlank(username) && StrUtil.isBlank(password))) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户名或密码为空");
        }

        // 2. 查询员工是否存在
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(username != null, Employee::getUsername, username)
                .eq(password != null, Employee::getPassword, password);
        Employee employee = getOne(queryWrapper);

        // 3. 不存在返回错误信息
        if (BeanUtil.isEmpty(employee)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户名或密码错误");
        }

        // 4. 判断账号状态是否异常
        if (employee.getStatus().equals(Employee.DISABLE)) {
            throw new BusinessException(ErrorCode.FORBIDDEN_ERROR, "账号状态异常");
        }

        // 5. 将员工id存入redis中

        // 5.1 有token,二次登录,直接续期
        String authorization = request.getHeader("Authorization");
        if (StrUtil.isNotBlank(authorization)) {
            stringRedisTemplate.expire(LOGIN_TOKEN_KEY + authorization, LOGIN_TOKEN_TTL, TimeUnit.DAYS);
            return Result.success("登录成功", new TokenVO(authorization, employee.getId()));
        }
        // 5.2 添加最后登录时间
        employee.setEndTime(LocalDateTime.now());
        boolean b = employeeMapper.updateEndTime(employee);

        if (b) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR);
        }

        // 5.3 无token,生成token保存到Redis中
        // true：取消uuid中的-
        String token = UUID.randomUUID().toString(true);

        // 存入redis
        stringRedisTemplate.opsForValue().set(LOGIN_TOKEN_KEY + token,
                employee.getId().toString(), LOGIN_TOKEN_TTL, TimeUnit.DAYS);

        // 6. 返回登录的token，让浏览器保存到请求头
        TokenVO tokenVo = new TokenVO(token, employee.getId());

        return Result.success("登录成功", tokenVo);
    }

    /**
     * 添加员工
     *
     * @param employeeAddDTO 员工数据对象
     * @return 返回添加结果
     */
    @Override
    public Result<String> addEmployee(EmployeeAddDTO employeeAddDTO) {
        ThrowUtils.throwIf(ObjectIsNullUtil.objectCheckIsNull(employeeAddDTO), ErrorCode.PARAMS_ERROR);
        Employee employee = new Employee();
        BeanUtil.copyProperties(employeeAddDTO, employee);
        boolean b = employeeMapper.addEmployee(employee);
        if (!b) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "新增失败");
        }
        return Result.success("添加成功");
    }

    /**
     * 员工信息分页查询
     *
     * @param employeePageDTO 查询参数，page、pageSize、name
     * @return 返回分页查询数据和记录数
     */
    @Override
    public Result<PageResult<EmployeeVO>> getEmployeePage(EmployeePageDTO employeePageDTO) {

        ThrowUtils.throwIf(ObjectIsNullUtil.objectCheckIsNull(employeePageDTO), ErrorCode.PARAMS_ERROR);
        long page = employeePageDTO.getPage();
        long pageSize = employeePageDTO.getPageSize();
        String name = employeePageDTO.getName();

        // 创建分页查询对象
        Page<Employee> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();

        // name存在就条件查询
        queryWrapper.eq(StrUtil.isNotBlank(name), Employee::getName, name);
        Page<Employee> employeePage = page(pageInfo, queryWrapper);

        // 创建结果对象
        PageResult<EmployeeVO> pageResult = new PageResult<>();

        // 将Employee对象转为EmployeeVO对象
        List<EmployeeVO> employeeVOList = employeePage.getRecords().stream().map(record -> {
            EmployeeVO employeeVO = new EmployeeVO();
            BeanUtil.copyProperties(record, employeeVO);

            // 查询创建人
            Employee employee = employeeMapper.selectById(record.getCreateUser());
            employeeVO.setCreateName(employee.getName());

            return employeeVO;
        }).collect(Collectors.toList());

        // 添加属性
        pageResult.setTotal(employeePage.getTotal());
        pageResult.setRecords(employeeVOList);

        return Result.success(pageResult);
    }

    /**
     * 根据id查询
     *
     * @param id 员工id
     * @return 返回员工详细信息
     */
    @Override
    public Result<EmployeeInfoVO> getEmployeeById(Long id) {
        // 查询员工对象信息
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(id != null, Employee::getId, id);
        Employee employee = getOne(queryWrapper);

        // 拷贝到VO
        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
        BeanUtil.copyProperties(employee, employeeInfoVO);

        // 获取创建人
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(employee.getCreateUser() != null, Employee::getId, employee.getCreateUser());
        Employee createEmployee = getOne(wrapper);

        // 属性赋值
        employeeInfoVO.setCreateName(createEmployee.getName());
        return Result.success(employeeInfoVO);
    }

    /**
     * 修改员工账号状态
     *
     * @param employee 员工id和要修改的状态
     * @return 返回操作的信息
     */
    @Override
    public Result<String> setEmployeeStatus(Employee employee) {
        ThrowUtils.throwIf(Objects.equals(BaseContext.getCurrentId(), 1L), ErrorCode.NO_AUTH_ERROR);
        boolean success = employeeMapper.setStatus(employee);
        if (success) {
            return Result.success("修改成功");
        }
        return Result.error(ErrorCode.OPERATION_ERROR);
    }

    /**
     * 修改员工信息
     *
     * @param employeeUpdateDTO 员工修改的字段对象
     * @return 返回操作结果
     */
    @Override
    public Result<String> updateEmployee(EmployeeUpdateDTO employeeUpdateDTO) {
        ThrowUtils.throwIf(!Objects.equals(BaseContext.getCurrentId(), 1L), ErrorCode.NO_AUTH_ERROR);
        ThrowUtils.throwIf(ObjectIsNullUtil.objectCheckIsNull(employeeUpdateDTO), ErrorCode.PARAMS_ERROR, "修改类容为空");
        Employee employee = BeanUtil.copyProperties(employeeUpdateDTO, Employee.class);
        try {
            boolean success = employeeMapper.update(employee);
            if (!success) {
                return Result.error(ErrorCode.OPERATION_ERROR);
            }
        } catch (BindingException e) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "修改数据不合要求");
        }
        return Result.success("修改成功");
    }

    /**
     * 员工密码修改
     *
     * @param employeeSetPwdDTO 员工id、员工新旧密码
     * @return 返回修改是否成功
     */
    @Override
    public Result<String> updateEmployeePassword(EmployeeSetPwdDTO employeeSetPwdDTO) {
        // 判断对象是否为空
        ThrowUtils.throwIf(employeeSetPwdDTO == null, ErrorCode.PARAMS_ERROR, "修改类容为空");

        Long id = BaseContext.getCurrentId();
        String oldPassword = employeeSetPwdDTO.getOldPassword();
        String newPassword = employeeSetPwdDTO.getNewPassword();

        // 根据id查询员工是否存在
        LambdaUpdateWrapper<Employee> queryWrapper = new LambdaUpdateWrapper<>();
        queryWrapper.eq(id != null, Employee::getId, id);

        Employee employee = getOne(queryWrapper);
        ThrowUtils.throwIf(employee == null, ErrorCode.NOT_FOUND_ERROR, "用户不存在");

        // 判断输入的原密码是否正确
        ThrowUtils.throwIf(!employee.getPassword().equals(oldPassword), ErrorCode.PARAMS_ERROR, "当前密码错误");

        // 修改密码
        employee.setPassword(newPassword);
        boolean success = employeeMapper.update(employee);

        if (success) {
            return Result.success("修改成功");
        }

        return Result.error(ErrorCode.OPERATION_ERROR);
    }

    /**
     * 退出登录
     *
     * @param token 请求token
     * @return 返回退出是否成功
     */
    @Override
    public Result<String> employeeLogout(String token) {
        Boolean success = stringRedisTemplate.delete(LOGIN_TOKEN_KEY + token);

        // 判断是否退出成功
        if (Boolean.TRUE.equals(success)) {
            return Result.success("退出成功");
        }
        return Result.error(ErrorCode.OPERATION_ERROR);
    }
}




