package com.op;

import com.op.bean.email.Email;
import com.op.service.MailSendService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuning on 17-2-17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TestMailSend {
    @Autowired
    private MailSendService mailSendService;

    @Test
    public void testSimpleMailSens() throws MessagingException {
        Email email = new Email();
        email.setAccepter("1748373312@qq.com");
        email.setSender("postmaster@networklab.cn");
        email.setTitle("test-xuning");
        email.setContent("这是一个测试, 点击<a href='http://www.baidu.com'>百度</a>");
        List<String> list=new ArrayList<>();
        list.add("postmaster@networklab.cn");
        list.add("18753377393@163.com");
        email.setRecipienters(list);
        Boolean res = mailSendService.sendSimpleEmail(email);
        Assert.assertTrue(res);
    }
}
