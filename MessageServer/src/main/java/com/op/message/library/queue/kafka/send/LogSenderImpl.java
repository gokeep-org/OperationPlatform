package com.op.message.library.queue.kafka.send;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.op.message.library.queue.name.QueueName;
import com.op.message.library.queue.Sender;
import com.op.message.library.queue.name.ServiceName;
import com.op.message.service.BaseService;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/1.
 ****************************************/
@Component(value = ServiceName.LOG_SENDER)
public class LogSenderImpl extends BaseService implements Sender {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogSenderImpl.class);
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @Override
    public void send(String msg) {
        if (null == msg) {
            LOGGER.info("push to elasticsearch message is null");
        } else {
            CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
            LOGGER.info("Send log message correlation id is: " + correlationData.getId());
            this.kafkaTemplate.send(QueueName.QUEUE_LOG, msg);
        }
    }

}