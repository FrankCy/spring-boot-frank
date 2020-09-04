package com.frank.boot.custom.maven.action.impl;

import com.frank.boot.custom.maven.action.ImportApplication;
import com.frank.boot.custom.maven.action.service.ImportMailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 *
 * @author cy
 * @version MailServiceImplTest.java, v 0.1 2020年09月03日 20:13 cy Exp $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { ImportApplication.class, ImportMailServiceImpl.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)//配置启动类
public class MailServiceImplTest {

    @Autowired
    private ImportMailService importMailService;

    @Test
    public void testSendSimpleMail() {
        importMailService.sendMail("cy880708@163.com", "主题：测试邮件发送", "测试内容！");
    }

    @Test
    public void testSendHtmlMail() {
        importMailService.sendHtmlMail("cy880708@163.com", "主题：测试HTML邮件发送", "<h1>测试HTML内容</h1>！");
    }

    @Test
    public void testSendAttachmentsMail() {
        importMailService.sendAttachmentsMail("cy880708@163.com", "主题：测试附件邮件发送", "测试附件邮件发送", "/Users/cy/Downloads/领域驱动设计精简版_V2.pdf");
    }

}
