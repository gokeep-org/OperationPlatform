package com.op.message.service;

import java.util.Map;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/13.
 ****************************************/
public interface MqService {
    /**
     * 同步日志数据到RabbitMQ
     * @param message
     */
    public void pushToElasticsearch(Map<String, Object> message);

}
