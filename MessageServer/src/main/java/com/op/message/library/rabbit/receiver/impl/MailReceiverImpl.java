package com.op.message.library.rabbit.receiver.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.op.message.bean.action.input.email.MailSendInput;
import com.op.message.exception.ErrorCode;
import com.op.message.library.rabbit.Queue.QueueName;
import com.op.message.library.rabbit.receiver.Receiver;
import com.op.message.library.rabbit.sender.MailSenderImpl;
import com.op.message.service.MailSendService;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/1.
 ****************************************/
@Component
@RabbitListener(queues = QueueName.EMIAL)
public class MailReceiverImpl implements Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(MailSenderImpl.class);
    @Autowired
    MailSendService mailSendService;
    @Override
    @RabbitHandler
    public void process(String jsonStr) {
        LOGGER.info("receiver message-->" + jsonStr);
        try {
            MailSendInput input = new Gson().fromJson(jsonStr, MailSendInput.class);
            mailSendService.sendCommonEmail(input);
        } catch (Exception e) {
            LOGGER.error(ErrorCode.SMTP_SEND_ERROR, e);
        }
    }
}
