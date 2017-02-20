package com.op.queue.sender;

import com.op.exception.ErrorCode;
import com.op.exception.OperationPlatformException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/15.
 ****************************************/
@Component
public class CustomerSender extends QueueSender {
	@Autowired
	private AmqpTemplate rabbitTemplate;
	private static final String queueName = "customer";

	@Override
	public void send(String message) {
		if (null == message && message.trim() != "") {
			throw new OperationPlatformException(ErrorCode.SEND_QUEUE_IS_NULL);
		}
		this.rabbitTemplate.convertAndSend(queueName, message);
	}
}
