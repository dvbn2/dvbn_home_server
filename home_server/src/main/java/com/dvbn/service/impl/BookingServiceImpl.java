package com.dvbn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dvbn.domain.Booking;
import com.dvbn.mapper.BookingMapper;
import com.dvbn.service.BookingService;
import org.springframework.stereotype.Service;

/**
 * @author dvbn
 * @description 针对表【booking(预订表)】的数据库操作Service实现
 * @createDate 2023-09-16 19:16:02
 */
@Service
public class BookingServiceImpl extends ServiceImpl<BookingMapper, Booking>
        implements BookingService {

}




