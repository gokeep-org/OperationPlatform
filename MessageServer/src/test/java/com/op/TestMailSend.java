package com.op;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.op.message.MessageBootstrap;
import com.op.message.bean.entity.email.Email;
import com.op.message.service.MailSendService;

/**
 * Created by xuning on 17-2-17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MessageBootstrap.class)
public class TestMailSend {
    @Autowired
    private MailSendService mailSendService;
    private Email email = new Email();
    private String mailSender = "postmaster@networklab.cn";
    private String eefungAccepter = "xuning@eefung.com";
    private String qqAccepter = "1748373312@qq.com";
    private String phoneAccepter = "18753377393@163.com";
    private String otherAccepter = "1250496032@qq.com";
    private String title = "这是一封测试邮件" + new Random().toString();
    private String content = "如果收到，无需回复，打扰了。。。";

    /**
     * 简单邮件
     * @throws MessagingException
     */
    @Test
    public void testSimpleMailSend() throws MessagingException {
        List<String> accepts = Arrays.asList(eefungAccepter, qqAccepter);
        email.setAccepter(accepts);
        email.setTitle(title);
        email.setContent(content);
        Boolean res = mailSendService.sendSimpleEmail(email);
        Assert.assertTrue(res);
    }

    /**
     * 抄送邮件
     * @throws MessagingException
     */
    @Test
    public void testRecipientersMailSend() throws MessagingException {
        email.setSender(mailSender);
        email.setTitle(title);
        email.setContent(content);
        List<String> recipientersList = Arrays.asList(qqAccepter);
        email.setRecipienters(recipientersList);
        Boolean res = mailSendService.sendRecipientsEmail(email);
        Assert.assertTrue(res);
    }

    /**
     * 密送邮件
     * @throws MessagingException
     */
    @Test
    public void testBccMailSend() throws MessagingException {
        email.setSender(mailSender);
        email.setTitle(title);
        email.setContent(content);
        List<String> bbcAccepterlist = Arrays.asList(qqAccepter);
        email.setBccAccepter(bbcAccepterlist);
        Boolean res = mailSendService.sendBccEmail(email);
        Assert.assertTrue(res);
    }

    /**
     * 带有附件的邮件
     * @throws MessagingException
     */
    @Test
    public void testAttachmentMailSens() throws MessagingException {
        List<String> accepts = Arrays.asList(qqAccepter);
        email.setAccepter(accepts);
        email.setSender(mailSender);
        email.setTitle(title);
        email.setContent(content);
        List<String> files = Arrays.asList("C:/Users/me/Desktop/test.txt");
        email.setAttachmentPath(files);
        Boolean res = mailSendService.sendAttachmentsEmail(email);
        Assert.assertTrue(res);
    }


    /**
     * 全功能邮件
     * @throws MessagingException
     */
    @Test
    public void testCommonMailSend() throws MessagingException {
        List<String> accepts = Arrays.asList(eefungAccepter, qqAccepter);
        email.setAccepter(accepts);
        email.setSender(mailSender);
        email.setTitle(title);
        email.setContent(content);
        List<String> recipientersList = Arrays.asList(otherAccepter);
        List<String> bccAccepts = Arrays.asList(phoneAccepter);
        email.setBccAccepter(bccAccepts);
        email.setRecipienters(recipientersList);
        List<File> files = Arrays.asList(new File("C:/Users/me/Desktop/test.txt"),
                new File("C:/Users/me/Desktop/test1.txt"),
                new File("C:/Users/me/Desktop/test.docx"));
        email.setAttachmentFile(files);
        Boolean res = mailSendService.sendCommonEmail(email);
        Assert.assertTrue(res);
    }
}