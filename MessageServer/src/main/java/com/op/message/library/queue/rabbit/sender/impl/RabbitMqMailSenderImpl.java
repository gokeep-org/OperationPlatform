package com.op.message.library.queue.rabbit.sender.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Component;

import com.op.message.library.queue.Sender;
import com.op.message.library.queue.kafka.send.KafkaMailSenderImpl;
import com.op.message.library.queue.name.ExchangeName;
import com.op.message.library.queue.name.RoutingKey;
import com.op.message.library.queue.name.ServiceName;
import com.op.message.service.BaseService;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/1.
 ****************************************/
@Component(value = ServiceName.RABBITMQ_MAIL_SENDER)
public class RabbitMqMailSenderImpl extends BaseService implements Sender, RabbitTemplate.ConfirmCallback {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMailSenderImpl.class);

    private RabbitTemplate rabbitTemplate;


    @Override
    public void send(String msg) {
        if (null == msg) {
            LOGGER.info("RabbitMQ: push to elasticsearch message is null");
        } else {
            CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
            LOGGER.info("RabbitMQ: Send mail message correlation id is: " + correlationData.getId());
            this.rabbitTemplate.convertAndSend(ExchangeName.OP_MAIL, RoutingKey.ONLY, msg, correlationData);
        }
    }

    /**
     * 回调方法
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            LOGGER.info("RabbitMQ: mail queue message process is successful, confirm id: " + correlationData.getId());
        } else {
            LOGGER.info("RabbitMQ: mail queue message process is fail, confirm id: " + correlationData.getId());
        }
    }
}
