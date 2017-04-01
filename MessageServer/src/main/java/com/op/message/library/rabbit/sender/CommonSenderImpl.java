package com.op.message.library.rabbit.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/1.
 ****************************************/
@Component
public class CommonSenderImpl implements CommonSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonSenderImpl.class);
    @Autowired
    public AmqpTemplate rabbitTemplate;

    @Override
    public void send(String queueName, String message) {
        if (null == message) {
            LOGGER.info("消息发送为null, 没有发送");
        } else {
            rabbitTemplate.convertAndSend(queueName, message);
        }
    }
}
