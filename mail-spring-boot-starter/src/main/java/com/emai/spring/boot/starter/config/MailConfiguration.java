package com.emai.spring.boot.starter.config;

import com.emai.spring.boot.starter.service.MailService;
import com.emai.spring.boot.starter.service.impl.MailServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
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
@ConditionalOnClass(value = { MailService.class, MailServiceImpl.class })
public class MailConfiguration {

    @Bean
    @ConditionalOnMissingBean
    JavaMailSenderImpl startJavaMailSenderImpl() {
        return new JavaMailSenderImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    MailService starterService() {
        return new MailServiceImpl();
    }

}
