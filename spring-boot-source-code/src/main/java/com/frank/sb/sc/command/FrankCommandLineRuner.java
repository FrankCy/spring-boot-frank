package com.frank.sb.sc.command;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-frank
 * @package: com.frank.sb.sc.command、
 * @email: cy880708@163.com
 * @date: 2019/9/7 下午4:38
 * @mofified By:
 */
@Configuration
@Order(value = 2)
public class FrankCommandLineRuner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- FrankCommandLineRuner ---");
    }
}
