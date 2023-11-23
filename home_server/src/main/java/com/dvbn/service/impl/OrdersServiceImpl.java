package com.dvbn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dvbn.domain.Orders;
import com.dvbn.mapper.OrdersMapper;
import com.dvbn.service.OrdersService;
import org.springframework.stereotype.Service;

/**
 * @author dvbn
 * @description 针对表【order(订单表)】的数据库操作Service实现
 * @createDate 2023-09-16 19:16:02
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
        implements OrdersService {

}




