package com.emai.spring.boot.starter.service;

/**
 *
 *
 * @author cy
 * @version MailService.java, v 0.1 2020年09月03日 19:22 cy Exp $
 */
public interface MailService {

    void sendMail(String to, String titile, String content);

}
