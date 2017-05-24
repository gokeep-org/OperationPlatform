package com.op.message.action.item;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.op.message.action.BaseAction;
import com.op.message.bean.action.output.BaseOutput;
import com.op.message.library.queue.Sender;
import com.op.message.library.queue.name.ServiceName;
import com.op.message.library.queue.rabbit.sender.impl.RabbitMqLogSenderImper;
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

    public static Sender mailSender = BaseService.getService(ServiceName.RABBITMQ_MAIL_SENDER, RabbitMqLogSenderImper.class);

//    public CommonSender commonSender = BaseService.getService(ServiceName.COMMON_SENDER, CommonSenderImpl.class);

    public static MqService mqService = BaseService.getService(ServiceName.MQ_SERVICE_IMPL, MqServiceImpl.class);

    private HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

    public String getUserId() {
        return request.getHeader("user_id");
    }
}