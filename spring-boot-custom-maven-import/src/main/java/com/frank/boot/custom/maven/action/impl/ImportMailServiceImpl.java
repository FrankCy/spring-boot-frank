package com.frank.boot.custom.maven.action.impl;

import com.emai.spring.boot.starter.service.MailService;
import com.frank.boot.custom.maven.action.service.ImportMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author cy
 * @version ImportMailServiceImpl.java, v 0.1 2020年09月03日 20:17 cy Exp $
 */
@Service("importMailServiceImpl")
public class ImportMailServiceImpl implements ImportMailService {

    @Autowired
    private MailService mailService;

    @Override
    public void sendMail(String to, String title, String content) {
        mailService.sendMail(to, title, content);
    }
}
