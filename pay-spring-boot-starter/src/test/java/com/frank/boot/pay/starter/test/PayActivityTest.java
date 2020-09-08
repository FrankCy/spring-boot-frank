package com.frank.boot.pay.starter.test;

import com.frank.boot.pay.starter.strategy.PayActivity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 *
 * @author cy
 * @version PayActivityTest.java, v 0.1 2020年09月08日 08:22 cy Exp $
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 配置启动类
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PayActivityTest {

    @Autowired
    private PayActivity payActivity;

    @Test
    public void testPayActivity() {
        payActivity.executePayStrategy();
    }

}
