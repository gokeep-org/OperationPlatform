package com.op.library.mail;

import com.op.bean.entity.email.Email;
import com.op.util.OpUtils;
import com.op.util.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/8.
 ****************************************/
@Component
public class SmtpServer {

	private static final Logger LOGGER = LoggerFactory.getLogger(SmtpServer.class);
	private static final String smtpHost = PropertiesUtil.getValue("spring.mail.host");
	private static final String smtpProt = PropertiesUtil.getValue("spring.mail.port");
	private static final String smtpUsername = PropertiesUtil.getValue("spring.mail.username");
	private static final String smtpPassword = PropertiesUtil.getValue("spring.mail.password");
	private static final String protocolType = PropertiesUtil.getValue("spring.mail.protocol");
	private static final String smtpAuth = PropertiesUtil.getValue("spring.mail.properties.mail.smtp.auth");
	private static final String smtpStarttlsEnable = PropertiesUtil.getValue("spring.mail.properties.mail.smtp.starttls.enable");
	private static final Boolean mailDebug = Boolean.parseBoolean(PropertiesUtil.getValue("spring.mail.debug"));
	private static final String mailCharset = PropertiesUtil.getValue("spring.mail.charset");
	private static Properties properties = new Properties();
	private Session session;
	private Transport transport;
	private Message message;
	private Email email;
	private Multipart multipart = new MimeMultipart();

	public SmtpServer() {
		properties.put("mail.host", smtpHost);
		properties.put("mail.smtp.port", smtpProt);
		properties.put("mail.transport.protocol", protocolType);
		properties.put("mail.smtp.auth", smtpAuth);
	}

	private void getTransport() throws MessagingException {
		transport = session.getTransport();
		transport.connect(smtpUsername, smtpPassword);
	}

	public SmtpServer setMailSessionInfo() throws MessagingException {
		session = Session.getInstance(getSmtpServerSessionProperties());
		session.setDebug(mailDebug);
		message = new MimeMessage(session);
		getTransport();
		return this;
	}

	public SmtpServer setEmail(Email mail) {
		email = mail;
		return this;
	}

	public SmtpServer setSender() throws MessagingException {
		message.setFrom(new InternetAddress(email.getSender()));
		return this;
	}

	public SmtpServer setReceiver() throws MessagingException {
		if (!OpUtils.checkObjectIsNull(email.getAccepter())) {
			email.getAccepter().forEach(e -> {
				try {
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(e));
				} catch (MessagingException e1) {
					LOGGER.info("add email accepter is exception");
				}
			});
		} else {
			LOGGER.info("add email receiver is exception");
		}
		return this;
	}

	public SmtpServer setRecipients() throws MessagingException {
		if (!OpUtils.checkObjectIsNull(email.getRecipienters())) {
			email.getRecipienters().forEach(e -> {
				try {
					message.addRecipient(Message.RecipientType.CC, new InternetAddress(e));
				} catch (MessagingException e1) {
					LOGGER.info("add email recipient is exception");
				}
			});
		} else {
			LOGGER.info("SMTP_RECIPIENTERS_IS_NULL");
		}
		return this;
	}

	public SmtpServer setBccAccepter() {
		if (!OpUtils.checkObjectIsNull(email.getBccAccepter())) {
			email.getBccAccepter().forEach(e -> {
				try {
					message.addRecipient(Message.RecipientType.BCC, new InternetAddress(e));
				} catch (MessagingException e1) {
					LOGGER.info("add email bccaccepter is exception");
				}
			});
		} else {
			LOGGER.info("SMTP_RECIPIENTERS_IS_NULL");
		}
		return this;
	}

	public SmtpServer setTitle() throws MessagingException {
		message.setSubject(email.getTitle());
		return this;
	}

	public SmtpServer setContent() throws MessagingException {
		BodyPart bodyPart = new MimeBodyPart();
		bodyPart.setText(email.getContent());
		multipart.addBodyPart(bodyPart);
		message.setContent(email.getContent(), mailCharset);
		return this;
	}

	public SmtpServer setAttachment() throws MessagingException {

		List<DataSource> sources = new ArrayList<>();
		if (!OpUtils.checkObjectIsNull(email.getAttachment())) {
			email.getAttachment().forEach(e -> {
				sources.add(new FileDataSource(e));
			});
		}
		if (!OpUtils.checkObjectIsNull(sources)) {
			sources.forEach(e -> {
				try {
					BodyPart messageBodyPart = new MimeBodyPart();
					messageBodyPart.setDataHandler(new DataHandler(e));
					messageBodyPart.setFileName(MimeUtility.encodeText(e.getName()));
					multipart.addBodyPart(messageBodyPart);
				} catch (MessagingException e1) {
					LOGGER.info("set attachment error");
				} catch (UnsupportedEncodingException e1) {
					LOGGER.info("get attachment file name error");
				}
			});
			message.setContent(multipart);
		}
		message.saveChanges();
		return this;
	}

	public void execute() {
		try {
			transport.sendMessage(message, message.getAllRecipients());
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

	public static String getSmtpProt() {
		return smtpProt;
	}

	public static String getSmtpUsername() {
		return smtpUsername;
	}

	public static String getSmtpPassword() {
		return smtpPassword;
	}

	public static String getProtocolType() {
		return protocolType;
	}

	public static String getSmtpAuth() {
		return smtpAuth;
	}

	public static String getSmtpStarttlsEnable() {
		return smtpStarttlsEnable;
	}

	public static Boolean getMailDebug() {
		return mailDebug;
	}
}
