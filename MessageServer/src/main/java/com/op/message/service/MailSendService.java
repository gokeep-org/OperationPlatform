package com.op.message.service;

import com.op.message.bean.entity.email.Email;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/7.
 ****************************************/
public interface MailSendService{
	Boolean sendSimpleEmail(Email email);

	Boolean sendRecipientsEmail(Email email);

	Boolean sendBccEmail(Email email);

	Boolean sendAttachmentsEmail(Email email);

	Boolean sendCommonEmail(Email email);

	Boolean sendTemplate(Email email);
}
