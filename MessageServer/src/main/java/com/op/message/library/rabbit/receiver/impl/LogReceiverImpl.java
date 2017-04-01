package com.op.message.library.rabbit.receiver.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;

import com.op.message.bean.entity.log.Log;
import com.op.message.exception.ErrorCode;
import com.op.message.library.rabbit.Queue.QueueName;
import com.op.message.library.rabbit.receiver.Receiver;
import com.op.message.util.OpUtils;

import requests.Requests;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/28.
 ****************************************/
@Component
@RabbitListener(queues = QueueName.LOG)
public class LogReceiverImpl implements Receiver {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private Requests requests;
    private static final Logger LOGGER = LoggerFactory.getLogger(LogReceiverImpl.class);

    @Override
    @RabbitHandler
    public void process(String jsonStr) {
        try {
            String esUri = loadBalancerClient.choose("ES").getUri().toString();
            Log log = OpUtils.gson().fromJson(jsonStr, Log.class);
            requests.post(esUri + "/log/info", log, null);
        } catch (Exception e) {
            LOGGER.info(ErrorCode.RABBIT_RECEIVER_FAILD);
        }
    }
}
