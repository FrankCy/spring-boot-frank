package com.frank.mail.service;

/**
 *
 *
 * @author cy
 * @version MailService.java, v 0.1 2020年09月02日 16:53 cy Exp $
 */
public interface MailService {

    /**
     * 发送普通邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     * @return
     */
    String sendSimpleMail(String to, String subject, String content);

    /**
     * 发送HTML邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     * @return
     */
    String sendHtmlMail(String to, String subject, String content);

    /**
     * 发送附件邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     * @param filePath 附件
     * @return
     */
    String sendAttachmentsMail(String to, String subject, String content, String filePath);

}
