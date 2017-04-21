package com.op.message.action.item;

import com.op.message.action.factory.BaseAction;
import com.op.message.bean.action.output.BaseOutput;
import com.op.message.library.rabbit.Queue.SenderName;
import com.op.message.library.rabbit.sender.CommonSender;
import com.op.message.library.rabbit.sender.CommonSenderImpl;
import com.op.message.library.rabbit.sender.LogSenderImpl;
import com.op.message.library.rabbit.sender.MailSenderImpl;
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

    public static Sender mailSender = BaseService.getService(SenderName.MAIL_SENDER, MailSenderImpl.class);

    public static Sender logSender = BaseService.getService(SenderName.LOG_SENDER, LogSenderImpl.class);

    public CommonSender commonSender = BaseService.getService(SenderName.COMMON_SENDER, CommonSenderImpl.class);

}