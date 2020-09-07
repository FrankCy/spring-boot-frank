package com.boot.frank.spi.action;

import com.boot.frank.spi.service.HelloSpi;

import java.util.ServiceLoader;

/**
 *
 *
 * @author cy
 * @version SpiDemo.java, v 0.1 2020年09月07日 15:10 cy Exp $
 */
public class SpiDemo {
    public static void main(String[] args) {
        // 执行不同厂商的业务实现，具体根据业务需求配置
        ServiceLoader<HelloSpi> serviceLoader = ServiceLoader.load(HelloSpi.class);
        for(HelloSpi helloSpi : serviceLoader) {
            helloSpi.sayHello();
        }
    }
}
