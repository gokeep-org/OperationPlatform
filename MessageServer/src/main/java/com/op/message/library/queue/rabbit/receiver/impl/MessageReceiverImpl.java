//package com.op.message.library.queue.rabbit.receiver.impl;
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.op.message.library.queue.rabbit.Queue.QueueName;
//import com.op.message.library.queue.rabbit.receiver.Receiver;
//import com.op.message.service.MailSendService;
//
///****************************************
// * Copyright (c) xuning.
// * 尊重版权，禁止抄袭!
// * 如有违反，必将追究其法律责任.
// * @Auther is xuning on 2017/2/20.
// ****************************************/
//
//@Component
//@RabbitListener(queues = QueueName.MESSAGE)
//public class MessageReceiverImpl implements Receiver {
//    private static final Logger LOGGER = LoggerFactory.getLogger(MessageReceiverImpl.class);
//    @Autowired
//    MailSendService mailSendService;
//
//    @RabbitHandler
//    @Override
//    public void process(String jsonStr) {
//        LOGGER.info("receiver message-->" + jsonStr);
//    }
//}