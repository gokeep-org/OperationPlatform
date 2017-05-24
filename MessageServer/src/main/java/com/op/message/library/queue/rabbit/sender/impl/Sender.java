//package com.op.message.library.queue.rabbit.sender.impl;
//
//import java.util.UUID;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.rabbit.support.CorrelationData;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.op.message.config.AmqpConfig;
//import com.op.message.library.queue.rabbit.Queue.ServiceName;
//
//
///****************************************
// * Copyright (c) xuning.
// * 尊重版权，禁止抄袭!
// * 如有违反，必将追究其法律责任.
// * @Auther is xuning on 2017/5/13.
// ****************************************/
//@Component(value = ServiceName.ES_SENDER)
//public class Sender implements com.op.message.library.queue.rabbit.sender.Sender, RabbitTemplate.ConfirmCallback {
//    private static final Logger LOGGER = LoggerFactory.getLogger(com.op.message.library.queue.rabbit.sender.Sender.class);
//
//    private RabbitTemplate rabbitTemplate;
//
//    @Autowired
//    public Sender(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//        this.rabbitTemplate.setConfirmCallback(this);
//    }
//
//    @Override
//    public void send(String msg) {
//        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
//        LOGGER.info("send message correlation id is: " + correlationData.getId());
//        this.rabbitTemplate.convertAndSend(AmqpConfig.FOO_EXCHANGE, AmqpConfig.FOO_ROUTINGKEY, msg, correlationData);
//    }
//
//    /**
//     * 回调方法
//     */
//    @Override
//    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//        if (ack) {
//            LOGGER.info("message process is successful, confirm id: " + correlationData.getId());
//        } else {
//            LOGGER.info("message process is fail, confirm id: " + correlationData.getId());
//        }
//    }
//}