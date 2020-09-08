package com.frank.boot.pay.starter.service.impl;

import com.frank.boot.pay.starter.PayStarterDemoApplication;
import com.frank.boot.pay.starter.service.PayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 *
 * @author cy
 * @version PayServiceImplTest.java, v 0.1 2020年09月08日 11:16 cy Exp $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { PayStarterDemoApplication.class, PayServiceImpl.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)//配置启动类
public class PayServiceImplTest {

    @Autowired
    PayService payService;

    @Test
    public void testPay() {
        payService.pay();
    }


}
