package com.frank.boot.pay.starter.config;

import com.frank.boot.pay.starter.factory.PayStrategyFactory;
import com.frank.boot.pay.starter.strategy.PayActivity;
import com.frank.boot.pay.starter.strategy.PayStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cy
 * @version PayConfiguration.java, v 0.1 2020年09月08日 08:37 cy Exp $
 */
@Configuration
@EnableConfigurationProperties(PayProperties.class)
public class PayConfiguration {

    @Autowired
    private PayProperties payProperties;

    PayStrategy payStrategy;

    PayActivity payActivity;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "pay.config", value = "enabled", matchIfMissing = true)
    PayActivity starterService() {
        this.payActivity = new PayActivity(PayStrategyFactory.getPayStrategy(payProperties.getMode()));
        return this.payActivity;
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "pay.config", value = "enabled", matchIfMissing = true)
    PayStrategy InitPayStrategy() {
        System.out.println("123 ---- " + payProperties.getMode());
        this.payStrategy = PayStrategyFactory.getPayStrategy(payProperties.getMode());
        return this.payStrategy;
    }
}
