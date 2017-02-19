package com.op.rest;

import com.op.action.factory.mail.EmailActionFactory;
import com.op.bean.action.input.email.MailSendInput;
import com.op.bean.action.output.email.MailSendOutput;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * Created by me on 2017/1/5.
 */
@Path("/email")
@Produces({MediaType.APPLICATION_JSON})
public class MailRest {
    
    @Path("/simple/send")
    @POST
    public MailSendOutput simpleMailSend(MailSendInput input) throws Exception {
        return EmailActionFactory.getMailSendAction(input).execute();
    }
    
    @Path("/recipienters/send")
    @POST
    public MailSendOutput RecipientersMailSend(MailSendInput input) throws Exception {
        return EmailActionFactory.getMailSendAction(input).execute();
    }
    
    @Path("/bcc/send")
    @POST
    public MailSendOutput bccMailSend(MailSendInput input) throws Exception {
        return EmailActionFactory.getMailSendAction(input).execute();
    }
    
    @Path("/attachment/send")
    @POST
    public MailSendOutput attachmentMailSend(MailSendInput input) throws Exception {
        return EmailActionFactory.getMailSendAction(input).execute();
    }
    
    @Path("/send")
    @POST
    public MailSendOutput mailSend(MailSendInput input) throws Exception {
        return EmailActionFactory.getMailSendAction(input).execute();
    }
}