package com.frank.sb.transactional;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-frank
 * @package: com.frank.sb.transactional、
 * @email: cy880708@163.com
 * @date: 2019/7/23 下午4:06
 * @mofified By:
 */
@SpringBootApplication
@MapperScan("com.frank.sb.transactional.dao.mapper")
public class TransactionalApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransactionalApplication.class, args);
    }
}
