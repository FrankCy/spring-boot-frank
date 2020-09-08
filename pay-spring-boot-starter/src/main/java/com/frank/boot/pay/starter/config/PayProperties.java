package com.frank.boot.pay.starter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 *
 * @author cy
 * @version PayProperties.java, v 0.1 2020年09月08日 08:35 cy Exp $
 */
@ConfigurationProperties(prefix = "pay.config")
public class PayProperties {

    /**
     * 支付方式
     */
    private String payMode;

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }
}
