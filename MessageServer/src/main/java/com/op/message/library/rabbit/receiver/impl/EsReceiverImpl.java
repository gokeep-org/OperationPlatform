package com.op.message.library.rabbit.receiver.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.op.message.exception.ErrorCode;
import com.op.message.library.rabbit.Queue.QueueName;
import com.op.message.library.rabbit.receiver.Receiver;
import com.op.util.bean.UriPath;
import com.op.util.common.RequestUtil;
import com.op.util.discovery.DiscoveryVip;
import com.op.util.discovery.ServerName;
import com.op.util.exception.OperationPlatformException;
import com.op.util.gson.SerializeUtil;
import com.op.util.requests.Requests;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/13.
 ****************************************/
@Component
@RabbitListener(queues = QueueName.ES)
public class EsReceiverImpl implements Receiver {
    @Autowired
    private Requests requests;
    @Autowired
    private DiscoveryVip discoveryVip;
    private static final Logger LOGGER = LoggerFactory.getLogger(EsReceiverImpl.class);

    /**
     * 异步处理日志的插入： log->rabbitmq->elasticsearch
     * @param jsonStr
     */
    @Override
    @RabbitHandler
    public void process(String jsonStr) {

        try {
            Map<String, Object> message = (Map<String, Object>) SerializeUtil.transfromStringToObject(jsonStr, Map.class);
            String esUri = discoveryVip.choose(ServerName.ES);
            String indexName = (String) message.get("index");
            String indexType = (String) message.get("type");
            Map<String, Object> body = (Map<String, Object>) message.get("body");
            requests.post(esUri + UriPath.ES + "/index/" + indexName + "/type/" + indexType, body, RequestUtil.setUserIdToRequest(null));
        } catch (Exception e) {
            LOGGER.info(ErrorCode.RABBIT_RECEIVER_FAILD);
            throw new OperationPlatformException("request params is invalid, found error");
        }
    }
}
