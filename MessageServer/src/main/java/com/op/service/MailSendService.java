package com.op.service;

import com.op.bean.email.Email;

import javax.mail.MessagingException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/7.
 ****************************************/
public interface MailSendService {
    public Boolean sendSimpleEmail(Email email) throws MessagingException;
    public Boolean sendAttachmentsEmail(Email email);
    public Boolean sendTemplate(Email email);
}
