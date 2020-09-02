package com.frank.mail.impl;

import com.frank.mail.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 *
 *
 * @author cy
 * @version MailServiceImpl.java, v 0.1 2020年09月02日 16:53 cy Exp $
 */
@Service("mailServiceImpl")
@Slf4j
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    /**
     * 配置文件中我的qq邮箱
     */
    @Value("${spring.mail.from}")
    private String from;

    @Override
    public String sendSimpleMail(String to, String subject, String content) {
        //创建SimpleMailMessage对象
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件发送人
        message.setFrom(from);
        //邮件接收人
        message.setTo(to);
        //邮件主题
        message.setSubject(subject);
        //邮件内容
        message.setText(content);
        //发送邮件
        mailSender.send(message);
        return "发送完成";
    }

    @Override
    public String sendHtmlMail(String to, String subject, String content) {

        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setTo(to);
            helper.setFrom(from);
            helper.setSubject(subject);
            helper.setText(content,true);
            mailSender.send(message);
            log.info("发送静态邮件成功");
        } catch (MessagingException e) {
            log.error("发送静态邮件失败：",e);
            return "发送失败";
        }

        return "发送成功";
    }

    @Override
    public String sendAttachmentsMail(String to, String subject, String content, String filePath) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
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
        }
        return "发送成功";
    }
}