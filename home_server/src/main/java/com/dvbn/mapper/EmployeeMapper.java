package com.dvbn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dvbn.annotation.AutoFill;
import com.dvbn.domain.Employee;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import static com.dvbn.enumeration.OperationType.UPDATE;

/**
 * @author dvbn
 * @description 针对表【employee(员工表)】的数据库操作Mapper
 * @createDate 2023-09-16 19:16:02
 * @Entity com.dvbn.domain.Employee
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    /**
     * 修改员工账号状态
     * @param employee 员工id和要修改的状态
     * @return 返回是否成功
     */
    @AutoFill(value = UPDATE)
    boolean setStatus(Employee employee);

    /**
     * 修改员工信息
     * @param employee 员工修改的字段对象
     * @return 修改结果
     */
    @AutoFill(value = UPDATE)
    boolean update(Employee employee);

    /**
     * 修改员工最后操作时间
     * @param employee 已员工id为key，更新时间为value
     * @return 修改是否成功
     */
    boolean updateEndTime(Employee employee);
}




