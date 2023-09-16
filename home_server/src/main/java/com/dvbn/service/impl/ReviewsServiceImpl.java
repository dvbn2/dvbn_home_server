package com.dvbn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dvbn.domain.Reviews;
import com.dvbn.mapper.ReviewsMapper;
import com.dvbn.service.ReviewsService;
import org.springframework.stereotype.Service;

/**
 * @author dvbn
 * @description 针对表【reviews(评论表)】的数据库操作Service实现
 * @createDate 2023-09-16 19:16:02
 */
@Service
public class ReviewsServiceImpl extends ServiceImpl<ReviewsMapper, Reviews>
        implements ReviewsService {

}




