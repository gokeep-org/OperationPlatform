//package com.op.message.library.rabbit.receiver.impl;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Component;
//
//import com.op.message.library.rabbit.Queue.ExchangeName;
//import com.op.message.library.rabbit.Queue.QueueName;
//import com.op.message.library.rabbit.Queue.RoutingKey;
//import com.op.message.library.rabbit.receiver.Receiver;
//import com.op.util.discovery.DiscoveryVip;
//import com.op.util.requests.Requests;
//
///****************************************
// * Copyright (c) xuning.
// * 尊重版权，禁止抄袭!
// * 如有违反，必将追究其法律责任.
// * @Auther is xuning on 2017/5/13.
// ****************************************/
//@Component
//@RabbitListener(queues = QueueName.ES)
//public class EsReceiverImpl implements Receiver {
//    @Autowired
//    private Requests requests;
//    @Autowired
//    private DiscoveryVip discoveryVip;
//    private static final Logger LOGGER = LoggerFactory.getLogger(EsReceiverImpl.class);
//
//    /**
//     * 设置交换机类型
//     */
//    @Bean
//    public DirectExchange defaultExchange() {
//        /**
//         * DirectExchange:按照routingkey分发到指定队列
//         * TopicExchange:多关键字匹配
//         * FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
//         * HeadersExchange ：通过添加属性key-value匹配
//         */
//        return new DirectExchange(ExchangeName.OP_ES);
//    }
//
//    /**
//     * 创建队列实例
//     * @return
//     */
//    @Bean
//    public Queue esQueue() {
//        return new Queue(QueueName.ES);
//    }
//
//    /**
//     * 将队列绑定到交换机
//     * @return
//     */
//    @Bean
//    public Binding binding() {
//        return BindingBuilder.bind(esQueue()).to(defaultExchange()).with(RoutingKey.ONLY);
//    }
//
//    /**
//     * 异步处理日志的插入： log->rabbitmq->elasticsearch
//     * @param jsonStr
//     */
//    @RabbitHandler
//    public void process(@Payload String jsonStr) {
//        LOGGER.info("receiver message is "+jsonStr);
////        try {
////            Map<String, Object> message = (Map<String, Object>) SerializeUtil.transfromStringToObject(jsonStr, Map.class);
////            String esUri = discoveryVip.choose(ServerName.ES);
////            String indexName = (String) message.get("index");
////            String indexType = (String) message.get("type");
////            Map<String, Object> body = (Map<String, Object>) message.get("body");
////            requests.post(esUri + UriPath.ES + "/index/" + indexName + "/type/" + indexType, body, null);
////        } catch (Exception e) {
////            LOGGER.error(ErrorCode.RABBIT_RECEIVER_FAILD);
////        }
//    }
//}
