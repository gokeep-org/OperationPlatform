package com.op.message.library.queue.kafka.receiver;

import java.util.Map;
import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.op.message.exception.ErrorCode;
import com.op.message.library.queue.name.QueueName;
import com.op.util.bean.UriPath;
import com.op.util.discovery.DiscoveryVip;
import com.op.util.discovery.ServerName;
import com.op.util.gson.SerializeUtil;
import com.op.util.requests.Requests;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/24.
 ****************************************/
public class KafkaLogListener {
    @Autowired
    private DiscoveryVip discoveryVip;
    @Autowired
    private Requests requests;
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaLogListener.class);

    @KafkaListener(topics = {QueueName.KAFKA_QUEUE_LOG})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            try {
                Map<String, Object> message = (Map<String, Object>) SerializeUtil.transfromStringToObject(kafkaMessage.get().toString(), Map.class);
                String esUri = discoveryVip.choose(ServerName.ES);
                String indexName = (String) message.get("index");
                String indexType = (String) message.get("type");
                Map<String, Object> body = (Map<String, Object>) message.get("body");
                requests.post(esUri + UriPath.ES + "/index/" + indexName + "/type/" + indexType, body, null);
            } catch (Exception e) {
                LOGGER.error(ErrorCode.KAFKA_RECEIVER_FAILD);
            }
        }
    }
}
