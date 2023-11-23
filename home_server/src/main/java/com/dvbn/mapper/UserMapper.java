package com.dvbn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dvbn.annotation.AutoFill;
import com.dvbn.domain.User;
import com.dvbn.enumeration.OperationType;

/**
 * @author dvbn
 * @description 针对表【user(用户表)】的数据库操作Mapper
 * @createDate 2023-09-16 19:16:02
 * @Entity com.dvbn.domain.User
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 修改用户数据
     * @param user 要修改的用户数据对象
     */
    @AutoFill(OperationType.UPDATE)
    boolean userUpdate(User user);
}




