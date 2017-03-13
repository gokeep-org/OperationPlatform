package com.op.message.action.item;

import com.op.message.action.factory.BaseAction;
import com.op.message.library.rabbit.sender.Sender;
import com.op.message.library.rabbit.sender.SenderImpl;
import com.op.message.service.BaseService;
import com.op.message.service.MailSendService;
import com.op.message.service.ServiceBeanNames;
import com.op.message.service.impl.MailSendServiceImpl;
import com.op.message.bean.action.output.BaseOutput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-2-18
 ****************************************/
public abstract class ItemAction <T extends BaseOutput> extends BaseAction<T> {
    public static MailSendService mailSendService = BaseService.getService(ServiceBeanNames.MAIL_SEND_SERVICE, MailSendServiceImpl.class);
    public static Sender senderService = BaseService.getService(ServiceBeanNames.SENDER_SERVICE, SenderImpl.class);


    public static MailSendService getMailSendService() {
        return mailSendService;
    }

    public static void setMailSendService(MailSendService mailSendService) {
        ItemAction.mailSendService = mailSendService;
    }
}