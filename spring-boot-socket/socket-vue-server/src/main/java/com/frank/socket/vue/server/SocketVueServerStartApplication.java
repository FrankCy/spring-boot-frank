package com.frank.socket.vue.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 *
 * @author cy
 * @version SocketVueServerStartApplication.java, v 0.1 2020年12月08日 1:50 下午 cy Exp $
 */
@SpringBootApplication
/**
 * 定时器，在Task.java中使用到，模拟页面定时刷新的样子
 */
@EnableScheduling
public class SocketVueServerStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocketVueServerStartApplication.class, args);
    }

}
