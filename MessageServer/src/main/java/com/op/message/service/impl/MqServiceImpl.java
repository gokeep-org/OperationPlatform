package com.op.message.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.op.message.library.queue.name.ServiceName;
import com.op.message.library.queue.Sender;
import com.op.message.service.BaseService;
import com.op.message.service.MqService;
import com.op.util.gson.SerializeUtil;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/13.
 ****************************************/
@Component(value = ServiceName.MQ_SERVICE_IMPL)
public class MqServiceImpl extends BaseService implements MqService {
    @Autowired
    @Qualifier(ServiceName.LOG_SENDER)
    private Sender sender;
    private static final Logger LOGGER = LoggerFactory.getLogger(MqServiceImpl.class);

    /**
     * 添加信息到ElasticSearch索引
     * @param message
     */
    @Override
    public void pushToElasticsearch(Map<String, Object> message) {
        String mapMessage = SerializeUtil.transfromObjectToString(message);
        sender.send(mapMessage);
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }
}
