package com.op.message.action.item;

import com.op.message.action.BaseAction;
import com.op.message.bean.action.output.BaseOutput;
import com.op.message.library.rabbit.Queue.ServiceName;
import com.op.message.library.rabbit.sender.CommonSender;
import com.op.message.library.rabbit.sender.impl.CommonSenderImpl;
import com.op.message.library.rabbit.sender.impl.LogSenderImpl;
import com.op.message.library.rabbit.sender.impl.MailSenderImpl;
import com.op.message.library.rabbit.sender.Sender;
import com.op.message.service.BaseService;
import com.op.message.service.MailSendService;
import com.op.message.service.MqService;
import com.op.message.service.ServiceBeanNames;
import com.op.message.service.impl.MailSendServiceImpl;
import com.op.message.service.impl.MqServiceImpl;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-2-18
 ****************************************/
public abstract class ItemAction<T extends BaseOutput> extends BaseAction<T> {
    public static MailSendService mailSendService = BaseService.getService(ServiceBeanNames.MAIL_SEND_SERVICE, MailSendServiceImpl.class);

    public static Sender mailSender = BaseService.getService(ServiceName.MAIL_SENDER, MailSenderImpl.class);

    public static Sender logSender = BaseService.getService(ServiceName.LOG_SENDER, LogSenderImpl.class);

    public CommonSender commonSender = BaseService.getService(ServiceName.COMMON_SENDER, CommonSenderImpl.class);

    public static MqService mqService = BaseService.getService(ServiceName.MQ_SERVICE_IMPL, MqServiceImpl.class);
}