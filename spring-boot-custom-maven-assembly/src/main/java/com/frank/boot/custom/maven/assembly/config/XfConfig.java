package com.frank.boot.custom.maven.assembly.config;

import com.frank.boot.custom.maven.assembly.impl.XfServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * 配置类,交给IOC容器
 * @EnableConfigurationProperties:告诉SpringBoot,让使用@ConfigurationProperties 注解的类生效。
 * @ConditionalOnProperty:
 * 注解控制 @Configuration是否生效。
 * 简单来说也就是我们可以通过在yml配置文件中控制
 * @Configuration 注解的配置类是否生效
 * @author cy
 * @version XfConfig.java, v 0.1 2020年09月03日 13:33 cy Exp $
 */
@Configuration
@EnableConfigurationProperties(XfProperties.class)
@ConditionalOnProperty(prefix = "xf",value = "enabled", matchIfMissing = true)
public class XfConfig {

    @Autowired
    private XfProperties xfProperties;

    @Bean
    public XfServiceImpl xfService() {
        return  new XfServiceImpl(xfProperties.getMsg(),xfProperties.getToWho());
    }

}