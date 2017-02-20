package com.op.library.rabbit.receiver;


import com.google.gson.Gson;
import com.op.bean.action.input.email.MailSendInput;
import com.op.service.MailSendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/20.
 ****************************************/

@Component
@RabbitListener(queues = "message")
public class ReceiverImpl implements Receiver {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReceiverImpl.class);
	@Autowired
	MailSendService mailSendService;

	@RabbitHandler
	@Override
	public void process( String jsonStr) {
		LOGGER.info("message" + jsonStr);

		try {
			MailSendInput input = new Gson().fromJson(jsonStr, MailSendInput.class);
			mailSendService.sendCommonEmail(input);
		} catch (Exception e) {
			LOGGER.error("发送邮件发生异常");
		}
	}

}
