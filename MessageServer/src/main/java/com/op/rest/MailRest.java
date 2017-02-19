package com.op.rest;

import com.op.action.factory.mail.EmailActionFactory;
import com.op.bean.action.input.email.MailSendInput;
import com.op.bean.action.output.email.MailSendOutput;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Objects;


/**
 * Created by me on 2017/1/5.
 */
@Path("/email")
@Produces({MediaType.APPLICATION_JSON})
public class MailRest {
	
	@Path("/simple/send")
	@POST
	public MailSendOutput mailSend1(MailSendInput input) throws Exception {
		if (!Objects.equals(null, input)){
			return EmailActionFactory.getMailSendAction(input).execute();
		}
		return null;
	}
}