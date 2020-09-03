package com.email.spring.boot.starter.test;

import com.emai.spring.boot.starter.MailApplication;
import com.emai.spring.boot.starter.service.MailService;
import com.emai.spring.boot.starter.service.impl.MailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 *
 * @author cy
 * @version MailServiceImplTest.java, v 0.1 2020年09月03日 20:43 cy Exp $
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 配置启动类
@SpringBootTest(classes = { MailApplication.class, MailServiceImpl.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MailServiceImplTest {

    @Autowired
    private MailService mailService;

    @Test
    public void testSendSimpleMail() {
        mailService.sendMail("cy880708@163.com", "主题：测试邮件发送", "测试邮件发送是否可用");
    }

}
