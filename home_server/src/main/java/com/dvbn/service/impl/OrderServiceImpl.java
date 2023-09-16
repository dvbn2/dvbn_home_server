package com.dvbn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dvbn.domain.Order;
import com.dvbn.mapper.OrderMapper;
import com.dvbn.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * @author dvbn
 * @description 针对表【order(订单表)】的数据库操作Service实现
 * @createDate 2023-09-16 19:16:02
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
        implements OrderService {

}




