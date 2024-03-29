package com.op.analysis.service.impl;

import org.springframework.stereotype.Service;

import com.op.analysis.bean.ServiceName;
import com.op.analysis.service.BaseService;
import com.op.analysis.service.UserAnalysisService;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/20.
 ****************************************/
@Service(value = ServiceName.USER_ANALYSIS_SERVICE)
public class UserAnalysisServiceImpl extends BaseService implements UserAnalysisService {
    @Override
    public long searchRepeatUserTotal() {
        return 0;
    }
}
