package com.dvbn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dvbn.domain.Report;
import com.dvbn.mapper.ReportMapper;
import com.dvbn.service.ReportService;
import org.springframework.stereotype.Service;

/**
 * @author dvbn
 * @description 针对表【report(举报表)】的数据库操作Service实现
 * @createDate 2023-09-16 19:16:02
 */
@Service
public class ReportServiceImpl extends ServiceImpl<ReportMapper, Report>
        implements ReportService {

}




