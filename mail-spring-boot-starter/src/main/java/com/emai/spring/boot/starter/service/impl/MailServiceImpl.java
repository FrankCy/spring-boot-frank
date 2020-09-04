package com.emai.spring.boot.starter.service.impl;

import com.emai.spring.boot.starter.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 *
 *
 * @author cy
 * @version MailService.java, v 0.1 2020年09月03日 19:22 cy Exp $
 */
@Slf4j
@Service
public class MailServiceImpl implements MailService {

    /**
     * 邮件发送人
     */
    private static final String FROM = "sendUser@163.com";

    /**
     * 邮件发送人名称
     */
    private static final String FROM_NAME = "发送人张某";

    /**
     * 邮件发送工具类
     */
    private JavaMailSenderImpl mailSender;

    public MailServiceImpl(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;
    }

    @SuppressWarnings("all")
    @Override
    public String sendMail(String to, String title, String content) {

        try {
            //创建SimpleMailMessage对象
            SimpleMailMessage message = new SimpleMailMessage();
            //邮件发送人
            message.setFrom(FROM);
            //邮件接收人
            message.setTo(to);
            //邮件主题
            message.setSubject(title);
            //邮件内容
            message.setText(content);
            //发送邮件
            this.mailSender.send(message);
        } catch (Exception e) {
            log.error("发送邮件错误", e);
            return "发送失败";
        }
        return "发送成功";
    }

    @SuppressWarnings("all")
    @Override
    public String sendHtmlMail(String to, String subject, String content) {

        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setTo(to);
            helper.setFrom(FROM, FROM_NAME);
            helper.setSubject(subject);
            helper.setText(content,true);
            mailSender.send(message);
        } catch (MessagingException e) {
            log.error("HTML邮件发送错误", e);
            return "发送失败";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            log.error("HTML邮件发送错误", e);
            return "发送失败";
        }
        return "发送成功";
    }

    @SuppressWarnings("all")
    @Override
    public String sendAttachmentsMail(String to, String subject, String content, String filePath) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(FROM, FROM_NAME);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
            mailSender.send(message);
            //日志信息
            log.info("邮件已经发送。");
        } catch (MessagingException e) {
            log.error("发送邮件时发生异常！", e);
            return "发送失败";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            log.error("发送邮件时发生异常！", e);
            return "发送失败";
        }
        return "发送成功";
    }
}
