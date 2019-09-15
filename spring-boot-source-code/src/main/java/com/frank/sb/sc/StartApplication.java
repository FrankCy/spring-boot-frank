package com.frank.sb.sc;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-frank
 * @package: com.frank.sb.sc、
 * @email: cy880708@163.com
 * @date: 2019/8/20 下午2:25
 * @mofified By:
 */
@SpringBootApplication
public class StartApplication {
    public static void main(String[] args) {
//        注释没有特殊需求的"模版化"启动方式
        SpringApplication.run(StartApplication.class, args);
//        SpringApplication bootstrap = new SpringApplication(StartApplication.class);
//        bootstrap.setBanner(new Banner() {
//            @Override
//            public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
//                // 打印一个喜欢的ASCII Arts字符画
//            }
//        });
//        bootstrap.setBannerMode(Banner.Mode.CONSOLE);
//        // 其它定义设置...
//        bootstrap.run(args);

        /***
         * 提示
         * 设置自定义banner最简单的方式是把ASCII Art字符画放到一个资源文件，然后通过ResourceBanner加载：
         * bootstrap.setBanner(new ResourceBanner(new ClassPathResource("banner.txt")));
         */
    }
}
