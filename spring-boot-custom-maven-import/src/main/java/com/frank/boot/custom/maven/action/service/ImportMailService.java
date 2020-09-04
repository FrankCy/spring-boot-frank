package com.frank.boot.custom.maven.action.service;

/**
 *
 *
 * @author cy
 * @version ImportMailServcie.java, v 0.1 2020年09月03日 20:16 cy Exp $
 */
public interface ImportMailService {

    /**
     * 发送邮件
     * @param to
     * @param title
     * @param content
     */
    void sendMail(String to, String title, String content);

    /**
     * 发送Html邮件
     * @param to
     * @param title
     * @param content
     */
    void sendHtmlMail(String to, String title, String content);

    /**
     * 发送含附件的邮件
     * @param to
     * @param title
     * @param content
     * @param fileUrl
     */
    void sendAttachmentsMail(String to, String title, String content, String fileUrl);

}
