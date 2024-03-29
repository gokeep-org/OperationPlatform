//package com.op.message.library.queue.rabbit.receiver.impl;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.handler.annotation.Payload;
//
//import com.op.message.config.AmqpConfig;
//
///****************************************
// * Copyright (c) xuning.
// * 尊重版权，禁止抄袭!
// * 如有违反，必将追究其法律责任.
// * @Auther is xuning on 2017/5/22.
// ****************************************/
//@Configuration
//@RabbitListener(queues = AmqpConfig.FOO_QUEUE)
//public class Listener {
//    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);
//
//    /** 设置交换机类型  */
//    @Bean
//    public DirectExchange defaultExchange() {
//        /**
//         * DirectExchange:按照routingkey分发到指定队列
//         * TopicExchange:多关键字匹配
//         * FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
//         * HeadersExchange ：通过添加属性key-value匹配
//         */
//        return new DirectExchange(AmqpConfig.FOO_EXCHANGE);
//    }
//
//    /**
//     * 创建队列实例
//     * @return
//     */
//    @Bean
//    public Queue fooQueue() {
//        return new Queue(AmqpConfig.FOO_QUEUE);
//    }
//
//    /**
//     * 将队列绑定到交换机
//     * @return
//     */
//    @Bean
//    public Binding binding() {
//        return BindingBuilder.bind(fooQueue()).to(defaultExchange()).with(AmqpConfig.FOO_ROUTINGKEY);
//    }
//
//    @RabbitHandler
//    public void process(@Payload String foo) {
//        LOGGER.info("Listener: " + foo);
//    }
//}