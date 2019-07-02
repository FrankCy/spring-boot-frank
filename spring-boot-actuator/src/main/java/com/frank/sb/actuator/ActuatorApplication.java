package com.frank.sb.actuator;

import com.frank.sb.actuator.config.MyEndPoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 启动类
 */
@SpringBootApplication
public class ActuatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActuatorApplication.class, args);
    }

    /**
     * 启动类中，添加下面函数，将自定义端点交由spring进行管理，令其生效
     */
    @Configuration
    static class MyEndpointConfiguration {
        @Bean
        @ConditionalOnMissingBean
        @ConditionalOnEnabledEndpoint
        public MyEndPoint myEndPoint() {
            return new MyEndPoint();
        }
    }

}
