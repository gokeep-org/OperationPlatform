package com.op.message.library.queue;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/15.
 ****************************************/

/**
 * 发送消息队列接口
 */
public interface Sender {
    /**
     * Kafka与RabbitMQ通用消息发送接口
     * @param message
     */
    void send(String message);
}