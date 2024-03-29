package com.op.message.action.factory;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;

import com.op.message.bean.entity.user.User;
import com.op.message.service.MailSendService;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-2-18
 ****************************************/
public abstract class BaseActionFactory {

    @Autowired
    protected static MailSendService mailSendService;

    public static MailSendService getMailSendService() {
        return mailSendService;
    }

    public static void setMailSendService(MailSendService mailSendService) {
        BaseActionFactory.mailSendService = mailSendService;
    }

    public final static User getUser() {
        User user = new User(MDC.get("user_id"));
        return user;
    }
}
