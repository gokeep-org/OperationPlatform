package com.op.analysis.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.op.analysis.bean.ServiceName;
import com.op.analysis.service.BaseService;
import com.op.analysis.service.MeasureAnalysisService;
import com.op.util.discovery.DiscoveryVip;
import com.op.util.gson.SerializeUtil;
import com.op.util.requests.Requests;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/25.
 ****************************************/
@Service(value = ServiceName.MEASURE_ANALYSIS_SERVICE)
public class MeasureAnalysisServiceImpl extends BaseService implements MeasureAnalysisService {

    @Autowired
    private Requests requests;
    @Autowired
    private DiscoveryVip discoveryVip;

    /**
     * 获取集群节点健康信息
     * @param serverName
     * @return
     */
    @Override
    public Map<String, Object> searchNodeHealthy(String serverName) {
        String nodeServerVip = discoveryVip.choose(serverName);
        String result = requests.get(nodeServerVip + "/health").json();
        return (Map<String, Object>) SerializeUtil.transfromStringToObject(result, Map.class);
    }

    @Override
    public Map<String, Object> saerchNodeCPUStatus() {
        return null;
    }

    @Override
    public Map<String, Object> searchNodeMemeryStatus() {
        return null;
    }

    public Requests getRequests() {
        return requests;
    }

    public void setRequests(Requests requests) {
        this.requests = requests;
    }

    public DiscoveryVip getDiscoveryVip() {
        return discoveryVip;
    }

    public void setDiscoveryVip(DiscoveryVip discoveryVip) {
        this.discoveryVip = discoveryVip;
    }
}
