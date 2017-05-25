//package com.op.message.library.queue.kafka.receiver;
//
//import java.util.Optional;
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//
//import com.google.gson.Gson;
//import com.op.message.bean.action.input.email.MailSendInput;
//import com.op.message.exception.ErrorCode;
//import com.op.message.library.queue.name.QueueName;
//import com.op.message.service.MailSendService;
//
///****************************************
// * Copyright (c) xuning.
// * 尊重版权，禁止抄袭!
// * 如有违反，必将追究其法律责任.
// * @Auther is xuning on 2017/5/24.
// ****************************************/
//public class KafkaMailListener {
//    @Autowired
//    private MailSendService mailSendService;
//    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMailListener.class);
//
//    @KafkaListener(topics = {QueueName.KAFKA_QUEUE_MAIL})
//    public void listen(ConsumerRecord<?, ?> record) {
//        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
//        if (kafkaMessage.isPresent()) {
//            String message = (String) kafkaMessage.get();
//            try {
//                MailSendInput input = new Gson().fromJson(message, MailSendInput.class);
//                mailSendService.sendCommonEmail(input);
//            } catch (Exception e) {
//                LOGGER.error(ErrorCode.SMTP_SEND_ERROR, e);
//            }
//        }
//    }
//}
