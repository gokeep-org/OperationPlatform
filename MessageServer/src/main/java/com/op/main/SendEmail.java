package com.op.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/7.
 ****************************************/
@RestController
@RequestMapping("/email")
public class SendEmail {
    @Autowired
    public JavaMailSender javaMailSender=new JavaMailSenderImpl();
    @RequestMapping(value = "/simple", method = RequestMethod.GET)
    public String sendSimpleEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("postmaster@networklab.cn");
        message.setTo("1748373312@qq.com");
        message.setSubject("xunivvsng的test");
        message.setText("wuiu shoudaovfdvfdvfdvfd ");

        javaMailSender.send(message);
        return "ok";
    }

}