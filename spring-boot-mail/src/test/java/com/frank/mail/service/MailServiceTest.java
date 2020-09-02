package com.frank.mail.service;

import com.frank.mail.MailApplication;
import com.frank.mail.impl.MailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 *
 * @author cy
 * @version MailServiceTest.java, v 0.1 2020年09月02日 16:56 cy Exp $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { MailApplication.class, MailServiceImpl.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)//配置启动类
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Test
    public void testSendSimpleMail() {
        System.out.println(mailService.sendSimpleMail("xxxx@163.com", "主题：测试邮件发送", "测试邮件发送是否可用"));
    }

    @Test
    public void testSendHtmlMail() {
        System.out.println(mailService.sendHtmlMail("xxxx@163.com", "主题：测试HTML邮件发送", "<h1>内容：测试HTML邮件</h1>"));
    }

    @Test
    public void testSendAttachmentsMail() {
        System.out.println(mailService.sendAttachmentsMail("xxxx@163.com", "主题：测试附件邮件发送", "测试附件邮件信息", "/Downloads/file.pdf"));
    }

}
