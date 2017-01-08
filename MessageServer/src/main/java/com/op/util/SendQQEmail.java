//package com.op.util;
//
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.util.Properties;
//
///**
// * Created by me on 2017/1/7.
// */
////unydwyogoevzcjai
//public class SendQQEmail {
//    public static void main(String[] args) throws MessagingException {
//        Properties prop=new Properties();
//        prop.put("mail.host","smtp.qq.cn" );
//        prop.put("mail.transport.protocol", "smtp");
//        prop.put("mail.smtp.auth", "true");
//        prop.put("mail.smtp.port", "465");
//        //使用java发送邮件5步骤
//        //1.创建sesssion
//        Session session=Session.getInstance(prop);
//        //开启session的调试模式，可以查看当前邮件发送状态
//        session.setDebug(true);
//        //2.通过session获取Transport对象（发送邮件的核心API）
//        Transport ts=session.getTransport();
//        //3.通过邮件用户名密码链接，阿里云默认是开启个人邮箱pop3、smtp协议的，所以无需在阿里云邮箱里设置
//        ts.connect("1748373312@qq.com", "unydwyogoevzcjai");
//        //4.创建邮件
//        MimeMessage msg=createSimpleMail(session);
//        //5.发送电子邮件
//        ts.sendMessage(msg, msg.getAllRecipients());
//    }
//
//
//
//
//    public static MimeMessage createSimpleMail(Session session) throws AddressException,MessagingException{
//        //创建邮件对象
//        MimeMessage mm=new MimeMessage(session);
//        //设置发件人
//        mm.setFrom(new InternetAddress("1748373312@qq.com"));
//        //设置收件人
//        mm.setRecipient(Message.RecipientType.TO, new InternetAddress("postmaster@networklab.cn"));
//        //设置抄送人
//        mm.setRecipient(Message.RecipientType.CC, new InternetAddress("postmaster@networklab.cn"));
//
//        mm.setSubject("test_)qq");
//        mm.setContent("验证码为690", "text/html;charset=gbk");
//
//        return mm;
//
//    }
//}
