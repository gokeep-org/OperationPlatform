package com.op.rest.lib;

import com.op.bean.email.Email;
import com.op.service.MailSendService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
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

	@Path("/mail/accept")
	@POST
	public String testMailAccept(Email email) {
		System.out.println(email.getTitle());
		return "OK";
	}

	@Path("/email/send")
	@GET
	public String mailSend1() {
		Email email = new Email();
		List<String> accepts = Arrays.asList(new String[]{"xuning@eefung.com", "1748373312@qq.com"});
		email.setAccepter(accepts);
		email.setSender("postmaster@networklab.cn");
		email.setTitle("test-xuning");
		email.setContent("这是一个测试, 点击<a href='http://www.baidu.com'>百度</a>");
		//		File file=new File("/home/xuning/1.txt");
		//		List<File> files = new ArrayList<>();
		//		files.add(file);
		//		email.setAttachmentList(files);
		List<String> list = new ArrayList<>();
		list.add("postmaster@networklab.cn");
		list.add("18753377393@163.com");
		list.add("xuning@eefung.com");
		list.add("1250496032@qq.com");
		email.setRecipienters(list);
		Boolean res = mailSendService.sendSimpleEmail(email);
		return "OK";
	}
}