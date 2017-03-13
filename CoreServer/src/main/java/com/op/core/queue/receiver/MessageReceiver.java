package com.op.core.queue.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/15.
 ****************************************/
@Component
@RabbitListener(queues = "message")
public class MessageReceiver extends QueueReceiver {
	private static final Logger LOGGER= LoggerFactory.getLogger(MessageReceiver.class);
	@RabbitHandler
	public void process(String jsonStr) throws Exception{
		LOGGER.info("message"+jsonStr);
	}
}
