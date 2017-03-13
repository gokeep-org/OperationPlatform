package com.op.message.library.rabbit.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.op.message.service.MailSendService;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/28.
 ****************************************/
@Component
@RabbitListener(queues = "log")
public class LogReceiverImpl implements Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogReceiverImpl.class);
    @Autowired
    MailSendService mailSendService;

    @Override
    public void process(String jsonStr) {
        LOGGER.info("log" + jsonStr);
    }
}
