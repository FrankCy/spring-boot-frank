package com.frank.sb.js.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-frank
 * @package: com.frank.sb.js.app、
 * @email: cy880708@163.com
 * @date: 2019/7/4 下午1:44
 * @mofified By:
 */
@SpringBootApplication
@MapperScan("com.frank.sb.js.app.dao.mapper")
public class AppApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }
}
