package com.frank.nacos.dubbo.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

/**
 *
 *
 * @author cy
 * @version DubboProviderStartApplication.java, v 0.1 2020年12月23日 11:14 上午 cy Exp $
 */
@SpringBootApplication
// 开启Dubbo服务的注解
@EnableDubbo
public class DubboProviderStartApplication {

    /**
     * 使用jar方式打包的启动方式
     */
    private static CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DubboProviderStartApplication.class, args).registerShutdownHook();
        COUNT_DOWN_LATCH.await();
    }

}
