package com.frank.boot.custom.maven.assembly.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * 指定键值对映射到Java实体类属性
 *
 * @author cy
 * @version XfProperties.java, v 0.1 2020年09月03日 13:30 cy Exp $
 */
@ConfigurationProperties(prefix = "xf")
public class XfProperties {
    private  String msg;
    private String toWho;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToWho() {
        return toWho;
    }

    public void setToWho(String toWho) {
        this.toWho = toWho;
    }
}