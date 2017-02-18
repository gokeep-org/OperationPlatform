package com.op.action.item;

import com.op.action.factory.BaseAction;
import com.op.bean.action.output.BaseOutput;
import com.op.service.BaseService;
import com.op.service.MailSendService;
import com.op.service.ServiceBeanNames;
import com.op.service.impl.MailSendServiceImpl;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-2-18
 ****************************************/
public abstract class ItemAction <T extends BaseOutput> extends BaseAction<T> {
    public static MailSendService mailSendService = BaseService.getService(ServiceBeanNames.MAIL_SEND_SERVICE, MailSendServiceImpl.class);
    
    public static MailSendService getMailSendService() {
        return mailSendService;
    }
    
    public static void setMailSendService(MailSendService mailSendService) {
        ItemAction.mailSendService = mailSendService;
    }
    //所有的service
}