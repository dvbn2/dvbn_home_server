package com.dvbn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dvbn.domain.Feedback;
import com.dvbn.mapper.FeedbackMapper;
import com.dvbn.service.FeedbackService;
import org.springframework.stereotype.Service;

/**
 * @author dvbn
 * @description 针对表【feedback(反馈表)】的数据库操作Service实现
 * @createDate 2023-09-16 19:16:02
 */
@Service
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback>
        implements FeedbackService {

}




