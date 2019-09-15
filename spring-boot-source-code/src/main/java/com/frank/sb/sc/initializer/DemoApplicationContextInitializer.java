package com.frank.sb.sc.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * 实现自定义ApplicationContextInitializer，只需实现一个接口的一个函数initialize
 */
@Configuration
public class DemoApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        // do whatever you want with applicationContext,
        // e.g. applicationContext.registerShutdownHook();
        System.out.println("这是 --- DemoApplicationContextInitializer ---");
    }
}
