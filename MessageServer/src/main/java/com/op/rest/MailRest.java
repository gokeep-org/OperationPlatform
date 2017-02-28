package com.op.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.op.action.factory.mail.EmailActionFactory;
import com.op.bean.action.input.email.MailSendInput;
import com.op.bean.action.output.email.MailSendOutput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-2-18
 ****************************************/

@Path("/email")
@Produces({MediaType.APPLICATION_JSON})
public class MailRest {

    @Path("/simple/send")
    @POST
    public MailSendOutput simpleMailSend(MailSendInput input) throws Exception {
        return EmailActionFactory.getMailAsyncSendAction(input).execute();
    }

    @Path("/recipienters/send")
    @POST
    public MailSendOutput RecipientersMailSend(MailSendInput input) throws Exception {
        return EmailActionFactory.getMailAsyncSendAction(input).execute();
    }

    @Path("/bcc/send")
    @POST
    public MailSendOutput bccMailSend(MailSendInput input) throws Exception {
        return EmailActionFactory.getMailAsyncSendAction(input).execute();
    }

    @Path("/attachment/send")
    @POST
    public MailSendOutput attachmentMailSend(MailSendInput input) throws Exception {
        return EmailActionFactory.getMailAsyncSendAction(input).execute();
    }

    @Path("/send")
    @POST
    public MailSendOutput mailAsyncSend(MailSendInput input) throws Exception {
        return EmailActionFactory.getMailAsyncSendAction(input).execute();
    }

    @Path("/sync/send")
    @POST
    public MailSendOutput mailSyncSend(MailSendInput input) throws Exception {
        return EmailActionFactory.getMailSyncSendAction(input).execute();
    }
}