package com.op.bean.sattic;

import com.op.bean.email.Email;

import java.util.Objects;
import java.util.Random;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/16.
 ****************************************/
public class MailTemplate {
	private static Email email = new Email();
	private static final String mailSender = "postmaster@networklab.cn";
	private static final String eefungAccepter = "xuning@eefung.com";
	private static final String qqAccepter = "1748373312@qq.com";
	private static final String phoneAccepter = "18753377393@163.com";
	private static final String otherAccepter = "1250496032@qq.com";
	private static final String title = "这是一封测试邮件" + new Random().toString();
	private static final String content = "如果收到，无需回复，打扰了。。。";
	private MailTemplate(){
		if (Objects.equals(null, email)){
			email=new Email();
			email.setSender(mailSender);
		}
	}

	public static final Email getRegistrerTemplate(){
		email.setTitle(title);
		return null;
	}

	public static final Email getWecomeTemplate(){
		return null;
	}
}
