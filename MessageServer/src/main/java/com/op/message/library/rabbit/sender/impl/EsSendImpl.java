package com.op.message.library.rabbit.sender.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.op.message.library.rabbit.Queue.QueueName;
import com.op.message.library.rabbit.Queue.ServiceName;
import com.op.message.library.rabbit.sender.Sender;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/13.
 ****************************************/
@Component(value = ServiceName.ES_SENDER)
public class EsSendImpl implements Sender {
    private static final Logger LOGGER = LoggerFactory.getLogger(EsSendImpl.class);
    @Autowired
    public AmqpTemplate rabbitTemplate;

    @Override
    public void send(String message) {
        if (null == message) {
            LOGGER.info("push to elasticsearch message is null");
        } else {
            rabbitTemplate.convertAndSend(QueueName.ES, message);
        }
    }
}
