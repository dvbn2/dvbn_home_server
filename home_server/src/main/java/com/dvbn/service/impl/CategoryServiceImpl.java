package com.dvbn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dvbn.domain.Category;
import com.dvbn.mapper.CategoryMapper;
import com.dvbn.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * @author dvbn
 * @description 针对表【category(民宿类型表)】的数据库操作Service实现
 * @createDate 2023-09-16 19:16:02
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
        implements CategoryService {

}




