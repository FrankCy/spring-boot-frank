package com.emai.spring.boot.starter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 *
 * @author cy
 * @version MailProperties.java, v 0.1 2020年09月03日 20:55 cy Exp $
 */
@ConfigurationProperties(prefix = "spring.mail")
public class MailProperties {

    /**
     * 发送邮件的服务器
     */
    private String host = "邮件服务器";

    /**
     * 发送人
     */
    private String fromName = "";

    /**
     * 发送邮件的邮箱地址
     */
    private String username = "";

    /**
     * 发送邮件的邮箱密码
     */
    private String password = "";

    /**
     * 接收邮件的邮箱
     */
    private String to = "";

    /**
     * 默认编码格式
     */
    private String defaultEncoding = "UTF-8";

    /**
     * 发送邮件的地址，和上面username一致
     */
    private String from = "";

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDefaultEncoding() {
        return defaultEncoding;
    }

    public void setDefaultEncoding(String defaultEncoding) {
        this.defaultEncoding = defaultEncoding;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}