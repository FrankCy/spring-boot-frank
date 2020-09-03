package com.emai.spring.boot.starter.service.impl;

import com.emai.spring.boot.starter.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author cy
 * @version MailService.java, v 0.1 2020年09月03日 19:22 cy Exp $
 */
@Slf4j
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSenderImpl mailSender;

    @SuppressWarnings("all")
    @Override
    public void sendMail(String to, String titile, String content) {

        try {
            //创建SimpleMailMessage对象
            SimpleMailMessage message = new SimpleMailMessage();
            //邮件发送人
            message.setFrom("jtmmrobot@tiens.com");
            //邮件接收人
            message.setTo(to);
            //邮件主题
            message.setSubject(titile);
            //邮件内容
            message.setText(content);
            //发送邮件
            mailSender.send(message);
        } catch (Exception e) {
            log.error("发送邮件错误", e);
        }
    }
}
