package com.dvbn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dvbn.domain.OrderDetail;
import com.dvbn.mapper.OrderDetailMapper;
import com.dvbn.service.OrderDetailService;
import org.springframework.stereotype.Service;

/**
 * @author dvbn
 * @description 针对表【order_detail(订单明细表)】的数据库操作Service实现
 * @createDate 2023-09-16 19:16:02
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail>
        implements OrderDetailService {

}




