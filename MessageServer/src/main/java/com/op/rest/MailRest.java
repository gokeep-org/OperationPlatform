package com.op.rest;

import com.op.bean.email.Email;
import com.op.service.MailSendService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.MessagingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by me on 2017/1/5.
 */
@Path("/test")
@Produces({MediaType.APPLICATION_JSON})
public class MailRest {
	@Autowired
	private MailSendService mailSendService;

	@Path("/test1")
	@GET
	public String xx() {
		return "{'a':'111'}";
	}

	@Path("/email/send")
	@GET
	public String mailSend1() {
		Email email = new Email();
		email.setAccepter("1748373312@qq.com");
		email.setSender("postmaster@networklab.cn");
		email.setTitle("test-xuning");
		email.setContent("这是一个测试, 点击<a href='http://www.baidu.com'>百度</a>");
		List<String> list=new ArrayList<>();
		list.add("postmaster@networklab.cn");
		list.add("18753377393@163.com");
		email.setRecipienters(list);
		try {
			Boolean res = mailSendService.sendSimpleEmail(email);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return "OK";
	}
}