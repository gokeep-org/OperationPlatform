package com.op.service.impl;

import com.op.bean.email.Email;
import com.op.library.lib.SmtpServer;
import com.op.service.MailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/16.
 ****************************************/
@Component
public class MailSendServiceImpl implements MailSendService {
	@Autowired
	private SmtpServer smtpServer;

	@Override
	public Boolean sendSimpleEmail(Email email) {
		try {
			smtpServer.setMailSessionInfo()
					.setEmail(email)
					.setSender()
					.setReceiver()
					.setTitle()
					.setContent()
					.execute();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean sendRecipientsEmail(Email email) {
		try {
			smtpServer.setMailSessionInfo()
					.setEmail(email)
					.setSender()
					.setReceiver()
					.setRecipients()
					.setTitle()
					.setContent()
					.execute();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean sendBccEmail(Email email) {
		try {
			smtpServer.setMailSessionInfo()
					.setEmail(email)
					.setSender()
					.setReceiver()
					.setBccAccepter()
					.setTitle()
					.setContent()
					.execute();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean sendAttachmentsEmail(Email email) {
		try {
			smtpServer.setMailSessionInfo()
					.setEmail(email)
					.setSender()
					.setReceiver()
					.setTitle()
					.setContent()
					.setAttachment()
					.execute();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean sendCommonEmail(Email email) {
		try {
			smtpServer.setMailSessionInfo()
					.setEmail(email)
					.setSender()
					.setReceiver()
					.setRecipients()
					.setBccAccepter()
					.setTitle()
					.setContent()
					.setAttachment()
					.execute();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean sendTemplate(Email email) {
		try {
			smtpServer.setMailSessionInfo()
					.setEmail(email)
					.setSender()
					.setReceiver()
					.setRecipients()
					.setBccAccepter()
					.setTitle()
					.setContent()
					.setAttachment()
					.execute();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
