package com.dvbn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dvbn.domain.AddressBooks;
import com.dvbn.mapper.AddressBooksMapper;
import com.dvbn.service.AddressBooksService;
import org.springframework.stereotype.Service;

/**
 * @author dvbn
 * @description 针对表【address_books(地址簿)】的数据库操作Service实现
 * @createDate 2023-09-16 19:16:02
 */
@Service
public class AddressBooksServiceImpl extends ServiceImpl<AddressBooksMapper, AddressBooks>
        implements AddressBooksService {

}




