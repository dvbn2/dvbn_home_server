package com.dvbn.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dvbn.domain.Orders;
import com.dvbn.domain.User;
import com.dvbn.dto.user.UserPageDTO;
import com.dvbn.dto.user.UserUpdateStatusDTO;
import com.dvbn.exception.BusinessException;
import com.dvbn.mapper.UserMapper;
import com.dvbn.result.PageResult;
import com.dvbn.result.Result;
import com.dvbn.service.OrdersService;
import com.dvbn.service.UserService;
import com.dvbn.utils.ErrorCode;
import com.dvbn.utils.ObjectIsNullUtil;
import com.dvbn.utils.ThrowUtils;
import com.dvbn.vo.user.UserVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dvbn
 * @description 针对表【user(用户表)】的数据库操作Service实现
 * @createDate 2023-09-16 19:16:02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Resource
    private OrdersService ordersService;

    @Resource
    private UserMapper userMapper;

    /**
     * 用户信息分页查询
     *
     * @param userPageDTO 分页查询条件对象
     * @return 返回查询结果对象
     */
    @Override
    public Result<PageResult<UserVO>> getUserPage(UserPageDTO userPageDTO) {
        ThrowUtils.throwIf(ObjectIsNullUtil.objectCheckIsNull(userPageDTO), ErrorCode.PARAMS_ERROR);

        Page<User> UserPage = new Page<>(userPageDTO.getPage(), userPageDTO.getPageSize());

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StrUtil.isNotBlank(userPageDTO.getPhoneNumber()), User::getPhoneNumber, userPageDTO.getPhoneNumber())
                .eq(ObjectUtil.isNotNull(userPageDTO.getUserType()), User::getUserType, userPageDTO.getUserType())
                .eq(ObjectUtil.isNotNull(userPageDTO.getSex()), User::getSex, userPageDTO.getSex())
                .eq(ObjectUtil.isNotNull(userPageDTO.getStatus()), User::getStatus, userPageDTO.getStatus())
                .orderByAsc(User::getStatus).orderByDesc(User::getScore).orderByAsc(User::getCreateTime);

        Page<User> page = page(UserPage, queryWrapper);

        PageResult<UserVO> pageResult = new PageResult<>();
        pageResult.setTotal(page.getTotal());

        List<UserVO> records = page.getRecords().stream().map(item -> {
            UserVO userVO = new UserVO();
            BeanUtil.copyProperties(item, userVO);

            Long userId = item.getId();
            // 根据id查询订单集合
            List<Orders> list = ordersService.list(new LambdaQueryWrapper<Orders>().eq(Orders::getCreateUser, userId));
            if (CollUtil.isNotEmpty(list)) {
                // 求和所有订单的消费金额
                BigDecimal consumption = list.stream().map(Orders::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
                userVO.setConsumption(consumption);
            } else {
                userVO.setConsumption(new BigDecimal("0"));
            }
            return userVO;
        }).collect(Collectors.toList());

        pageResult.setRecords(records);

        return Result.success(pageResult);
    }

    /**
     * 用户数据修改
     *
     * @param userUpdateStatusDTO 修改数据对象
     * @return 返回修改结果
     */
    @Override
    public Result<String> updateUserStatus(UserUpdateStatusDTO userUpdateStatusDTO) {

        ThrowUtils.throwIf(ObjectIsNullUtil.objectCheckIsNull(userUpdateStatusDTO), ErrorCode.PARAMS_ERROR);
        User user = new User();
        BeanUtil.copyProperties(userUpdateStatusDTO, user);

        try {
            boolean result = userMapper.userUpdate(user);
            ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        } catch (BusinessException e) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return Result.success("操作成功");
    }
}




