package com.dvbn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dvbn.domain.User;
import com.dvbn.mapper.UserMapper;
import com.dvbn.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author dvbn
 * @description 针对表【user(用户表)】的数据库操作Service实现
 * @createDate 2023-09-16 19:16:02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

}




