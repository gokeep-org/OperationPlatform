package com.op.action.factory;

import com.op.bean.entity.user.User;
import com.op.service.MailSendService;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;

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
    
    public final static User getUser(){
        User user = new User(Long.parseLong(MDC.get("user_id")));
        return user;
    }
}
