//package com.op.util;
//
//import java.util.Properties;
//
//import javax.mail.Message;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//public class SendEmailTools{
//	public static void main(String[] args) {
//		SendEmailTools.SendMail("1250496032@qq.com", "贱人艳", "你很丑");
//	}
//	private SendEmailTools(){}
//	private static String from="18753377393@163.com";
//	private static String password="xnjm0611";
//	static Properties properties = new Properties();
//	static
//	   {
//			properties.put("mail.smtp.host", "smtp.163.com");
//		   properties.put("mail.smtp.socketFactory.port", "143");
//		   properties.put("mail.smtp.socketFactory.class",
//				   		"javax.net.ssl.SSLSocketFactory");
//		   properties.put("mail.smtp.auth", "true");
//		   properties.put("mail.smtp.port", "25");
//	   }
//
//	public static boolean SendMail(String sendaddress,String sendtitle,String sendcontent){
//
//		Boolean ret = false;
//	    try
//	    {
//	       Session session = Session.getDefaultInstance(properties,
//	          new javax.mail.Authenticator() {
//			protected PasswordAuthentication
//	          getPasswordAuthentication() {
//	          return new PasswordAuthentication(from, password);
//	      }});
//
//	       Message message = new MimeMessage(session);
//	       message.setFrom(new InternetAddress(from));
//	       message.setRecipients(Message.RecipientType.TO,
//	          InternetAddress.parse(sendaddress));
//	       message.setSubject(sendtitle);
//	       message.setText(sendcontent);
//	       Transport.send(message);
//	       ret=true;
//	    }
//	    catch(Exception e)
//	    {
//	       e.printStackTrace();
//	       ret =false;
//	    }
//		return ret;
//	}
//}
