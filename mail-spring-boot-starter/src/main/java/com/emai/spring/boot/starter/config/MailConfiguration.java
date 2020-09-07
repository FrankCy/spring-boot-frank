package com.emai.spring.boot.starter.config;

import com.emai.spring.boot.starter.service.MailService;
import com.emai.spring.boot.starter.service.impl.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 *
 *
 * @author cy
 * @version MailConfiguration.java, v 0.1 2020年09月03日 19:24 cy Exp $
 */
@Configuration
@EnableConfigurationProperties(MailProperties.class)
@ConditionalOnClass(value = { MailService.class, MailServiceImpl.class })
public class MailConfiguration {

    @Autowired
    private MailProperties mailProperties;

    private JavaMailSenderImpl javaMailSender;

    @Bean
    @ConditionalOnMissingBean
    JavaMailSenderImpl InitJavaMailSender() {
        this.javaMailSender = new JavaMailSenderImpl();
        this.javaMailSender.setHost(mailProperties.getHost());
        this.javaMailSender.setUsername(mailProperties.getUsername());
        this.javaMailSender.setPassword(mailProperties.getPassword());
        this.javaMailSender.setDefaultEncoding(mailProperties.getDefaultEncoding());
        return this.javaMailSender;
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "spring.mail", value = "enabled", matchIfMissing = true)
    MailService starterService() {
        return new MailServiceImpl(this.javaMailSender);
    }

}
