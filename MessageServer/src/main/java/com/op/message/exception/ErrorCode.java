package com.op.message.exception;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/15.
 ****************************************/
public class ErrorCode {
    public static final String SMTP_RECIPIENTERS_IS_NULL = "smtp recipienters is null";
    public static final String SMTP_ACCEPTER_IS_NULL = "smtp accepter is null";
    public static final String SMTP_SEND_ERROR = "smtp mail send error";
    public static final String RABBIT_RECEIVER_FAILD = "rabbitmq receiver and send is faild";
    public static final String KAFKA_RECEIVER_FAILD = "kafka receiver and send is faild";
    public static final String PUSH_MESSAGE_TO_ELASTICSEARCH_IS_FAIL = "push message to elasticsearch is fail";

}
