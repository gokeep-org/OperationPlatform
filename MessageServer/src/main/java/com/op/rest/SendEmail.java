package com.op.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by me on 2017/1/6.
 */
@RestController
@RequestMapping("/email")
public class SendEmail {

    @Autowired
    JavaMailSender mailSender;

    @RequestMapping(value = "/simple", method = RequestMethod.GET)
    public String sendSimpleEmail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("18753377393@163.com");//发送者.
        message.setTo("xuning@eefung.com");//接收者.
        message.setSubject("测试邮件（邮件主题）");//邮件主题.
        message.setText("这是邮件内容");//邮件内容.
        mailSender.send(message);//发送邮件
        return "OK";
    }

    public JavaMailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
}