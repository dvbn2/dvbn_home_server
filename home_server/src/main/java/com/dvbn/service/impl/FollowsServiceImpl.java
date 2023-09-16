package com.dvbn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dvbn.domain.Follows;
import com.dvbn.mapper.FollowsMapper;
import com.dvbn.service.FollowsService;
import org.springframework.stereotype.Service;

/**
 * @author dvbn
 * @description 针对表【follows(关注表)】的数据库操作Service实现
 * @createDate 2023-09-16 19:16:02
 */
@Service
public class FollowsServiceImpl extends ServiceImpl<FollowsMapper, Follows>
        implements FollowsService {

}




