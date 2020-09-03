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

    private String host;

    private String fromName;

    private String username;

    private String password;

    private String to;

    private String defaultEncoding;

    private String from;

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