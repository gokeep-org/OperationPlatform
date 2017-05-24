package com.op.message.library.queue.rabbit.receiver.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.op.message.exception.ErrorCode;
import com.op.message.library.queue.name.QueueName;
import com.op.message.library.queue.rabbit.receiver.Receiver;
import com.op.util.bean.UriPath;
import com.op.util.discovery.DiscoveryVip;
import com.op.util.discovery.ServerName;
import com.op.util.gson.SerializeUtil;
import com.op.util.requests.Requests;


/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/28.
 ****************************************/
@Component
@RabbitListener(queues = QueueName.RABBITMQ_QUEUE_LOG)
public class LogReceiverImpl implements Receiver {
    @Autowired
    private Requests requests;
    @Autowired
    private DiscoveryVip discoveryVip;

    private static final Logger LOGGER = LoggerFactory.getLogger(LogReceiverImpl.class);

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
//        return new DirectExchange(ExchangeName.OP_LOG);
//    }
//
//    /**
//     * 创建队列实例
//     * @return
//     */
//    @Bean
//    public Queue logQueue() {
//        return new Queue(QueueName.RABBITMQ_QUEUE_LOG);
//    }
//
//    /**
//     * 将队列绑定到交换机
//     * @return
//     */
//    @Bean
//    public Binding binding() {
//        return BindingBuilder.bind(logQueue()).to(defaultExchange()).with(RoutingKey.ONLY);
//    }


    @RabbitHandler
    public void process(String jsonStr) {
        try {
            Map<String, Object> message = (Map<String, Object>) SerializeUtil.transfromStringToObject(jsonStr, Map.class);
            String esUri = discoveryVip.choose(ServerName.ES);
            String indexName = (String) message.get("index");
            String indexType = (String) message.get("type");
            Map<String, Object> body = (Map<String, Object>) message.get("body");
            requests.post(esUri + UriPath.ES + "/index/" + indexName + "/type/" + indexType, body, null);
        } catch (Exception e) {
            LOGGER.error(ErrorCode.RABBIT_RECEIVER_FAILD);
        }
    }

    public Requests getRequests() {
        return requests;
    }

    public void setRequests(Requests requests) {
        this.requests = requests;
    }

    public DiscoveryVip getDiscoveryVip() {
        return discoveryVip;
    }

    public void setDiscoveryVip(DiscoveryVip discoveryVip) {
        this.discoveryVip = discoveryVip;
    }
}
