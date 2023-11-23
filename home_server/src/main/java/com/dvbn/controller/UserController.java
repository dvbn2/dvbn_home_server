package com.dvbn.controller;

import com.dvbn.dto.user.UserUpdateStatusDTO;
import com.dvbn.dto.user.UserPageDTO;
import com.dvbn.result.PageResult;
import com.dvbn.result.Result;
import com.dvbn.service.UserService;
import com.dvbn.vo.user.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author dvbn
 * @title: UserController
 * @createDate 2023/11/7 12:10
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户信息分页查询
     * @param userPageDTO 分页查询条件对象
     * @return 返回查询结果对象
     */
    @GetMapping("/page")
    public Result<PageResult<UserVO>> getUserPage(UserPageDTO userPageDTO) {
        log.info("UserPageDTO ===>{}", userPageDTO);
        return userService.getUserPage(userPageDTO);
    }

    /**
     * 用户数据修改
     * @param userUpdateStatusDTO 修改数据对象
     * @return 返回修改结果
     */
    @PutMapping
    public Result<String> updateUserStatus(@RequestBody UserUpdateStatusDTO userUpdateStatusDTO) {
        return userService.updateUserStatus(userUpdateStatusDTO);
    }
}
