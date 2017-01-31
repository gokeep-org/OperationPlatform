package com.op.rest.v1;

import com.op.service.MailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/31.
 ****************************************/
@Controller
public class SendEmailRest {
	@Autowired
	private MailSendService mailSendService;
	public String sendSimpleEmail(
			String sender,
			String recver,
			String title,
			String content) {

		return "success";

	}
}
