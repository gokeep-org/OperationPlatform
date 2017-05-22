package com.op.message.library.rabbit.receiver.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.op.message.bean.action.input.email.MailSendInput;
import com.op.message.exception.ErrorCode;
import com.op.message.library.rabbit.Queue.ExchangeName;
import com.op.message.library.rabbit.Queue.QueueName;
import com.op.message.library.rabbit.Queue.RoutingKey;
import com.op.message.library.rabbit.receiver.Receiver;
import com.op.message.library.rabbit.sender.impl.MailSenderImpl;
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
    @Autowired
    private MailSendService mailSendService;

    private static final Logger LOGGER = LoggerFactory.getLogger(MailSenderImpl.class);

    /**
     * 设置交换机类型
     */
    @Bean
    public DirectExchange defaultExchange() {
        /**
         * DirectExchange:按照routingkey分发到指定队列
         * TopicExchange:多关键字匹配
         * FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
         * HeadersExchange ：通过添加属性key-value匹配
         */
        return new DirectExchange(ExchangeName.OP_MAIL);
    }

    /**
     * 创建队列实例
     * @return
     */
    @Bean
    public Queue emailQueue() {
        return new Queue(QueueName.EMIAL);
    }

    /**
     * 将队列绑定到交换机
     * @return
     */
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(emailQueue()).to(defaultExchange()).with(RoutingKey.ONLY);
    }

    /**
     * 异步邮件处理
     * @param jsonStr
     */
    @RabbitHandler
    public void process(@Payload String jsonStr) {
        try {
            MailSendInput input = new Gson().fromJson(jsonStr, MailSendInput.class);
            mailSendService.sendCommonEmail(input);
        } catch (Exception e) {
            LOGGER.error(ErrorCode.SMTP_SEND_ERROR, e);
        }
    }
}
