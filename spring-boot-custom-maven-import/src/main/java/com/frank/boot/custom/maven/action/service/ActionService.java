package com.frank.boot.custom.maven.action.service;

/**
 *
 *
 * @author cy
 * @version ActionService.java, v 0.1 2020年09月03日 17:06 cy Exp $
 */
public interface ActionService {

    /**
     * 发送邮件
     * @param to
     * @param title
     * @param content
     */
    String sendMail(String to, String title, String content);

}
