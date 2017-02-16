package com.op.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/16.
 ****************************************/
public class ApacheCommonsEmail {
	public static void main(String[] args) {
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.networklab.cn");// 设置使用发电子邮件的邮件服务器，这里以qq邮箱为例（其它例如：【smtp.163.com】，【smtp.sohu.com】）
		try {

//			Properties prop=new Properties();postmaster@networklab.cn", "Xnjm0611
//			prop.put("mail.host","smtp.networklab.cn" );
//			prop.put("mail.transport.protocol", "smtp");
//			prop.put("mail.smtp.auth", "true");
//			prop.put("mail.smtp.port", "25");
			// 收件人邮箱
			email.addTo("1748373312@qq.com");
			;
			// 邮箱服务器身份验证
			email.setAuthentication("postmaster@networklab.cn", "Xnjm0611");
			// 发件人邮箱
			email.setFrom("postmaster@networklab.cn");
			// 邮件主题
			email.setSubject("test-apache-commons-emails");
			// 邮件内容
			email.setMsg("我爱你徐宁");
			// 发送邮件
			email.send();
		} catch (EmailException ex) {
			ex.printStackTrace();
		}
	}
}
