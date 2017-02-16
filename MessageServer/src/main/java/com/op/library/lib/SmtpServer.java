package com.op.library.lib;

import com.op.bean.email.Email;
import com.op.util.OpUtils;
import com.op.util.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/8.
 ****************************************/
@Component
public class SmtpServer {

	private static PropertiesUtil propertiesUtil;
	private static final Logger LOGGER = LoggerFactory.getLogger(SmtpServer.class);
	private static String smtpHost = PropertiesUtil.getValue("spring.mail.host");
	private static String smtpProt = PropertiesUtil.getValue("spring.mail.port");
	private static String smtpUsername = PropertiesUtil.getValue("spring.mail.username");
	private static String smtpPassword = PropertiesUtil.getValue("spring.mail.password");
	private static String protocolType = PropertiesUtil.getValue("spring.mail.protocol");
	private static String smtpAuth = PropertiesUtil.getValue("spring.mail.properties.mail.smtp.auth");
	private static String smtpStarttlsEnable = PropertiesUtil.getValue("spring.mail.properties.mail.smtp.starttls.enable");
	private static Properties properties = new Properties();
	private Session session;
	private Transport transport;
	private MimeMessage mimeMessage;

	public SmtpServer() {
		properties.put("mail.host", smtpHost);
		properties.put("mail.smtp.port", smtpProt);
		properties.put("mail.transport.protocol", protocolType);
		properties.put("mail.smtp.auth", smtpAuth);
	}

	public SmtpServer setMailSessionInfo() {
		session = Session.getInstance(getSmtpServerSessionProperties());
		session.setDebug(false);
		return this;
	}

	public SmtpServer setMailSessionInfo(Boolean sessionIsDebug) {
		session = Session.getInstance(getSmtpServerSessionProperties());
		session.setDebug(sessionIsDebug);
		return this;
	}

	public SmtpServer setMailTransport() throws MessagingException {
		transport = session.getTransport();
		transport.connect(smtpUsername, smtpPassword);
		return this;
	}

	public SmtpServer contractMimeMessage(Email email) throws MessagingException {
		mimeMessage = new MimeMessage(session);
		mimeMessage.setFrom(new InternetAddress(email.getSender()));
		mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email.getAccepter()));
		//设置抄送人
		if (!OpUtils.checkObjectIsNull(email.getRecipienters())) {
			email.getRecipienters().forEach(e -> {
				try {
					mimeMessage.setRecipient(Message.RecipientType.CC, new InternetAddress(e));
				} catch (MessagingException e1) {
					LOGGER.info("recipient is exception");
				}
			});
		} else {
			LOGGER.info("SMTP_RECIPIENTERS_IS_NULL");
		}
		mimeMessage.setSubject(email.getTitle());
		mimeMessage.setContent(email.getContent(), "text/html;charset=gbk");

		return this;
	}

	public void execute() {
		try {
			transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
			transport.close();
		} catch (MessagingException e) {
			LOGGER.info("send email is error: ", e);
		}
	}

	public static Properties getSmtpServerSessionProperties() {
		return properties;
	}

	public static String getSmtpHost() {
		return smtpHost;
	}

	public static void setSmtpHost(String smtpHost) {
		SmtpServer.smtpHost = smtpHost;
	}

	public static String getSmtpProt() {
		return smtpProt;
	}

	public static void setSmtpProt(String smtpProt) {
		SmtpServer.smtpProt = smtpProt;
	}

	public static String getSmtpUsername() {
		return smtpUsername;
	}

	public static void setSmtpUsername(String smtpUsername) {
		SmtpServer.smtpUsername = smtpUsername;
	}

	public static String getSmtpPassword() {
		return smtpPassword;
	}

	public static void setSmtpPassword(String smtpPassword) {
		SmtpServer.smtpPassword = smtpPassword;
	}

	public static String getProtocolType() {
		return protocolType;
	}

	public static void setProtocolType(String protocolType) {
		SmtpServer.protocolType = protocolType;
	}

	public static String getSmtpAuth() {
		return smtpAuth;
	}

	public static void setSmtpAuth(String smtpAuth) {
		SmtpServer.smtpAuth = smtpAuth;
	}

	public static String getSmtpStarttlsEnable() {
		return smtpStarttlsEnable;
	}

	public static void setSmtpStarttlsEnable(String smtpStarttlsEnable) {
		SmtpServer.smtpStarttlsEnable = smtpStarttlsEnable;
	}
}
