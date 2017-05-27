package com.op.analysis.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.op.analysis.bean.ServiceName;
import com.op.analysis.service.BaseService;
import com.op.analysis.service.LogAnalysisService;
import com.op.util.bean.UriPath;
import com.op.util.discovery.DiscoveryVip;
import com.op.util.discovery.ServerName;
import com.op.util.gson.SerializeUtil;
import com.op.util.requests.Requests;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/27.
 ****************************************/
@Service(value = ServiceName.LOG_ANALYSIS_SERVICE)
public class LogAnalysisServiceImpl extends BaseService implements LogAnalysisService {
    @Autowired
    private Requests requests;
    @Autowired
    private DiscoveryVip discoveryVip;

    @Override
    public Map<String, Object> analysisUserLogin() {
        return null;
    }

    @Override
    public Map<String, Object> analyUserOperLogInfo() {
        return null;
    }

    @Override
    public List searchSystemLogInfoList() {
        return null;
    }

    @Override
    public List searchUserErrorLogInfoList() {
        return null;
    }

    @Override
    public List searchSyatemErrorInfoList() {
        return null;
    }

    @Override
    public long searchSystemLogTotal() {
        return 0;
    }

    @Override
    public Map<String, Object> analysisUserLiveness() {
        return null;
    }

    @Override
    public Map<String, Object> commonLogAnalysis(String index, String type, Map query) {
        String esUrl = discoveryVip.choose(ServerName.ES);
        String result = requests.post(esUrl + UriPath.ES + "/search/index/" + index + "/type/" + type, query, null).json();
        return (Map<String, Object>) SerializeUtil.transfromStringToObject(result, Map.class);
    }
}
