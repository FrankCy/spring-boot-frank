package com.frank.boot.custom.maven.action.impl;

import com.frank.boot.custom.maven.action.ImportApplication;
import com.frank.boot.custom.maven.action.service.ActionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 *
 * @author cy
 * @version ActionServiceImplTest.java, v 0.1 2020年09月03日 17:10 cy Exp $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { ImportApplication.class, ActionServiceImpl.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)//配置启动类
public class ActionServiceImplTest {


    @Autowired
    private ActionService actionService;

    @Test
    public void testSendSimpleMail() {
        System.out.println(actionService.sendMail("cy880708@163.com", "主题：测试邮件发送", "测试邮件发送是否可用"));
    }

}
