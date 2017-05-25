package com.op.analysis.service;

import java.util.Map;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/25.
 ****************************************/
public interface MeasureAnalysisService {
    /**
     * 获取当前集群系统的使用健康值
     */
    public Map<String, Object> searchNodeHealthy();

    /**
     * 获取结群节点CPU使用情况
     * @return
     */
    public Map<String, Object> saerchNodeCPUStatus();

    /**
     * 集群节点内存使用情况
     */
    public Map<String, Object> searchNodeMemeryStatus();
}
