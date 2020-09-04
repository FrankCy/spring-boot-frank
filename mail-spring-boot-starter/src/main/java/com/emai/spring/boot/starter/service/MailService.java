package com.emai.spring.boot.starter.service;

/**
 *
 *
 * @author cy
 * @version MailService.java, v 0.1 2020年09月03日 19:22 cy Exp $
 */
public interface MailService {

    /**
     * 发送普通邮件
     * @param to
     * @param title
     * @param content
     * @return
     */
    String sendMail(String to, String title, String content);

    /**
     * 发送HTML邮件
     * @param to
     * @param title
     * @param content
     * @return
     */
    String sendHtmlMail(String to, String title, String content);

    /**
     * 发送附件邮件
     * @param to
     * @param title
     * @param content
     * @param filePath
     * @return
     */
    String sendAttachmentsMail(String to, String title, String content, String filePath);

}
