//package com.op.service.impl;
//
//import com.op.bean.email.Email;
//import com.op.library.lib.SmtpServer;
//import com.op.bean.sattic.ResultMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
///****************************************
// * Copyright (c) xuning.
// * 尊重版权，禁止抄袭!
// * 如有违反，必将追究其法律责任.
// * @Auther is xuning on 2017/1/7.
// ****************************************/
//public class SimpleMailSendServiceImpl extends BaseSendEmailService<ResultMessage> {
//    @Autowired
//    private SmtpServer smtpServer;
//    private Email email;
//    @Override
//    protected void setupSession() throws MessagingException {
//        Session session=Session.getInstance(smtpServer.getSmtpServerSessionProperties());
//        //开启session的调试模式，可以查看当前邮件发送状态
//        session.setDebug(true);
//        //2.通过session获取Transport对象（发送邮件的核心API
//        Transport ts=session.getTransport();
//        //3.通过邮件用户名密码链接，阿里云默认是开启个人邮箱pop3、smtp协议的，所以无需在阿里云邮箱里设置
//        ts.connect(smtpServer.getSmtpUsername(), smtpServer.getSmtpPassword());
//        //4.创建邮件
//        MimeMessage msg=createSimpleMail(session);
//        //5.发送电子邮件
//        ts.sendMessage(msg, msg.getAllRecipients());
//    }
//
//    @Override
//    protected ResultMessage send() throws MessagingException {
//        //创建邮件对象
//        MimeMessage mm=new MimeMessage(session);
//        //设置发件人
//        mm.setFrom(new InternetAddress("postmaster@networklab.cn"));
//        //设置收件人
//        mm.setRecipient(Message.RecipientType.TO, new InternetAddress("1748373312@qq.com"));
//        //设置抄送人
//        mm.setRecipient(Message.RecipientType.CC, new InternetAddress("postmaster@networklab.cn"));
//        mm.setSubject("XXX网站注册邮件！");
//        mm.setContent("验证码为690", "text/html;charset=gbk");
//        return mm;
//    }
//}
