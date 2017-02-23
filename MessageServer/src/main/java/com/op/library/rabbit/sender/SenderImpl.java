package com.op.library.rabbit.sender;

import com.op.service.BaseService;
import com.op.service.ServiceBeanNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/20.
 ****************************************/
@Service(ServiceBeanNames.SENDER_SERVICE)
public class SenderImpl extends BaseService implements Sender, RabbitTemplate.ConfirmCallback {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	private static final Logger LOGGER = LoggerFactory.getLogger(SenderImpl.class);

	public SenderImpl() {

	}

	@Autowired
	public SenderImpl(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
		//		rabbitTemplate.setConfirmCallback(this); //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
	}


	@Override
	public void send(String queueName, String message) {
		CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
		rabbitTemplate.convertAndSend(
				queueName,
				message
		);
	}

	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		System.out.println(" 回调id:" + correlationData);
		if (ack) {
			LOGGER.info("消息成功消费");
		} else {
			LOGGER.info("消息消费失败" + cause);
		}
	}
}