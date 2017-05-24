package com.op.message.library.queue.name;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/1.
 ****************************************/

/**
 * 队列消息发送者实现
 */
public final class ServiceName {
    public static final String RABBITMQ_MAIL_SENDER = "rabbitmq_mailSendImpl";
    public static final String RABBITMQ_LOG_SENDER = "rabbitmq_logSenderImpl";
    public static final String KAFKA_MAIL_SENDER = "kafka_mailSendImpl";
    public static final String KAFKA_LOG_SENDER = "kafka_logSenderImpl";
    public static final String MQ_SERVICE_IMPL = "mqServiceImpl";

//    public static final String MESSAGE_SENDER = "messageSenderImpl";
//    public static final String ES_SENDER = "esSenderImpl";
//    public static final String COMMON_SENDER = "commonSenderImpl";
}
