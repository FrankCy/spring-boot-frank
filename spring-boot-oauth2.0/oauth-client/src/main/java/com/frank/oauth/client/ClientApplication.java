package com.frank.oauth.client;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-oauth2.0
 * @package: com.frank.oauth.client、
 * @email: cy880708@163.com
 * @date: 2019/5/24 下午1:38
 * @mofified By:
 */
@SpringBootApplication
@MapperScan("com.frank.oauth.server.mapper")
@ComponentScan("com.frank.oauth")
public class ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }
}
