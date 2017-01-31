package com.op.service.impl;

import com.op.bean.email.Email;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.internet.AddressException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/31.
 ****************************************/
public abstract class BaseSendEmailService<T> {

	protected abstract void setupSession() throws MessagingException;

	protected abstract T send() throws MessagingException;

	public T execute() {
		setupSession();
		T t = send();
		return t;
	}
}
