package com.op.message.action.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.op.message.action.factory.BaseAction;
import com.op.message.bean.action.output.BaseOutput;
import com.op.message.library.rabbit.Queue.SenderName;
import com.op.message.library.rabbit.sender.CommonSender;
import com.op.message.library.rabbit.sender.Sender;
import com.op.message.service.BaseService;
import com.op.message.service.MailSendService;
import com.op.message.service.ServiceBeanNames;
import com.op.message.service.impl.MailSendServiceImpl;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-2-18
 ****************************************/
public abstract class ItemAction<T extends BaseOutput> extends BaseAction<T> {
    public static MailSendService mailSendService = BaseService.getService(ServiceBeanNames.MAIL_SEND_SERVICE, MailSendServiceImpl.class);

    @Autowired
    @Qualifier(SenderName.MAIL_SENDER)
    public static Sender mailSender;

    @Autowired
    @Qualifier(SenderName.LOG_SENDER)
    public static Sender logSender;

    @Autowired
    public CommonSender commonSender;

    public static MailSendService getMailSendService() {
        return mailSendService;
    }

    public static void setMailSendService(MailSendService mailSendService) {
        ItemAction.mailSendService = mailSendService;
    }

    public static Sender getMailSender() {
        return mailSender;
    }

    public static void setMailSender(Sender mailSender) {
        ItemAction.mailSender = mailSender;
    }

    public static Sender getLogSender() {
        return logSender;
    }

    public static void setLogSender(Sender logSender) {
        ItemAction.logSender = logSender;
    }

    public CommonSender getCommonSender() {
        return commonSender;
    }

    public void setCommonSender(CommonSender commonSender) {
        this.commonSender = commonSender;
    }
}