package com.op.analysis.action.item;


import com.op.analysis.action.BaseAction;
import com.op.analysis.bean.ServiceName;
import com.op.analysis.bean.action.output.BaseOutput;
import com.op.analysis.service.BaseService;
import com.op.analysis.service.CustomerAnalysisService;
import com.op.analysis.service.LogAnalysisService;
import com.op.analysis.service.MeasureAnalysisService;
import com.op.analysis.service.UserAnalysisService;
import com.op.analysis.service.impl.CustomerAnalysisServiceImpl;
import com.op.analysis.service.impl.LogAnalysisServiceImpl;
import com.op.analysis.service.impl.MeasureAnalysisServiceImpl;
import com.op.analysis.service.impl.UserAnalysisServiceImpl;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-2-18
 ****************************************/
public abstract class ItemAction<T extends BaseOutput> extends BaseAction<T> {
    public CustomerAnalysisService customerAnalysisService = BaseService.getService(ServiceName.CUSTOMER_ANALYSIS_SERVICE, CustomerAnalysisServiceImpl.class);
    public LogAnalysisService logAnalysisService = BaseService.getService(ServiceName.LOG_ANALYSIS_SERVICE, LogAnalysisServiceImpl.class);
    public MeasureAnalysisService measureAnalysisService = BaseService.getService(ServiceName.MEASURE_ANALYSIS_SERVICE, MeasureAnalysisServiceImpl.class);
    public UserAnalysisService userAnalysisService = BaseService.getService(ServiceName.USER_ANALYSIS_SERVICE, UserAnalysisServiceImpl.class);

}