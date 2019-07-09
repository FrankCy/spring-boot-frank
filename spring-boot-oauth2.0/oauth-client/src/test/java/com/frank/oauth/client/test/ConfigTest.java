package com.frank.oauth.client.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: bdjr-data-reporting
 * @package: com.bdjr.reporting.access.test、
 * @email: cy880708@163.com
 * @date: 2019/5/28 下午5:15
 * @mofified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigTest {
    // 注入配置的阴钥
    @Value("${system.user.password.secret}")
    private String secret;

    @Test
    public void testPasswordEncoder(){
        Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder(secret);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String pbk1 = pbkdf2PasswordEncoder.encode("123456");
        String pbk2 = pbkdf2PasswordEncoder.encode("123456");

        String bcr1 = bCryptPasswordEncoder.encode("123456");
        String bcr2 = bCryptPasswordEncoder.encode("123456");

        System.out.println("pbk1: " + pbk1);
        System.out.println("pbk2: " + pbk2);
        System.out.println("pbk1 password:" + pbkdf2PasswordEncoder.matches("123456",pbk1));
        System.out.println("pbk2 password:" + pbkdf2PasswordEncoder.matches("123456",pbk2));

        System.out.println("---------------------");

        System.out.println("bcr1: " + bcr1);
        System.out.println("bcr2: " + bcr2);
        System.out.println("bcr1 password:" + bCryptPasswordEncoder.matches("123456",bcr1));
        System.out.println("bcr2 password:" + bCryptPasswordEncoder.matches("123456",bcr2));
    }

}
