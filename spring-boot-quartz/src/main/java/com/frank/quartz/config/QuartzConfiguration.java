package com.frank.quartz.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 *
 * @author cy
 * @version $Id: QuartzConfiguration.java, v 0.1 2020年06月11日 16:29 cy Exp $
 */
@Configuration
@EnableScheduling
public class QuartzConfiguration {


    /**
     * 配置Quartz独立数据源的配置
     */
    @Bean
    @QuartzDataSource
    @ConfigurationProperties(prefix = "spring.datasource.dynamic.datasource.quartz")
    public DruidDataSource quartzDataSource(){
        return new DruidDataSource();
    }
}
