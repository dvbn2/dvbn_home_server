package com.dvbn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dvbn.domain.Amenities;
import com.dvbn.mapper.AmenitiesMapper;
import com.dvbn.service.AmenitiesService;
import org.springframework.stereotype.Service;

/**
 * @author dvbn
 * @description 针对表【amenities(民宿设备表)】的数据库操作Service实现
 * @createDate 2023-09-16 19:16:02
 */
@Service
public class AmenitiesServiceImpl extends ServiceImpl<AmenitiesMapper, Amenities>
        implements AmenitiesService {

}




