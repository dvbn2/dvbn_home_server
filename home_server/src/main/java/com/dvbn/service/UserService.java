package com.dvbn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dvbn.domain.User;
import com.dvbn.dto.user.UserUpdateStatusDTO;
import com.dvbn.dto.user.UserPageDTO;
import com.dvbn.result.PageResult;
import com.dvbn.result.Result;
import com.dvbn.vo.user.UserVO;

/**
 * @author dvbn
 * @description 针对表【user(用户表)】的数据库操作Service
 * @createDate 2023-09-16 19:16:02
 */
public interface UserService extends IService<User> {

    /**
     * 用户信息分页查询
     * @param userPageDTO 分页查询条件对象
     * @return 返回查询结果对象
     */
    Result<PageResult<UserVO>> getUserPage(UserPageDTO userPageDTO);

    /**
     * 用户数据修改
     * @param userUpdateStatusDTO 修改数据对象
     * @return 返回修改结果
     */
    Result<String> updateUserStatus(UserUpdateStatusDTO userUpdateStatusDTO);
}
