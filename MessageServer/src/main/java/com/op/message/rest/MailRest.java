package com.op.message.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.op.message.action.factory.mail.EmailActionFactory;
import com.op.message.bean.action.input.email.MailSendInput;
import com.op.message.bean.action.output.email.MailSendOutput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-2-18
 ****************************************/

@Path("/email")
@Produces({MediaType.APPLICATION_JSON})
public class MailRest {
    /**
     * 发送异步消息到消息队列-发送简单邮件
     * @param input
     * @return
     * @throws Exception
     */
    @Path("/simple/send")
    @POST
    public MailSendOutput simpleMailSend(MailSendInput input) throws Exception {
        return EmailActionFactory.getMailAsyncSendAction(input).execute();
    }

    /**
     * 发送异步消息到消息队列-发送抄送邮件
     * @param input
     * @return
     * @throws Exception
     */
    @Path("/recipienters/send")
    @POST
    public MailSendOutput RecipientersMailSend(MailSendInput input) throws Exception {
        return EmailActionFactory.getMailAsyncSendAction(input).execute();
    }

    /**
     * 发送异步消息到消息队列-发送密送邮件
     * @param input
     * @return
     * @throws Exception
     */
    @Path("/bcc/send")
    @POST
    public MailSendOutput bccMailSend(MailSendInput input) throws Exception {
        return EmailActionFactory.getMailAsyncSendAction(input).execute();
    }

    /**
     * 发送异步消息到消息队列-发送附件邮件
     * @param input
     * @return
     * @throws Exception
     */
    @Path("/attachment/send")
    @POST
    public MailSendOutput attachmentMailSend(MailSendInput input) throws Exception {
        return EmailActionFactory.getMailAsyncSendAction(input).execute();
    }

    /**
     * 发送异步消息到消息队列-发送通用邮件
     * @param input
     * @return
     * @throws Exception
     */
    @Path("/send")
    @POST
    public MailSendOutput mailAsyncSend(MailSendInput input) throws Exception {
        return EmailActionFactory.getMailAsyncSendAction(input).execute();
    }

    /**
     * 发送同步消息-发送通用邮件
     * @param input
     * @return
     * @throws Exception
     */
    @Path("/sync/send")
    @POST
    public MailSendOutput mailSyncSend(MailSendInput input) throws Exception {
        return EmailActionFactory.getMailSyncSendAction(input).execute();
    }
}