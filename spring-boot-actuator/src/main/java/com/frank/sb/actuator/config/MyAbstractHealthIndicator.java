package com.frank.sb.actuator.config;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * 自定义健康端点
 * 功能强大一些。
 * DataSourceHealthIndicator 与 RedisHealthIndicator 写法相同
 */
@Component("frankHealthIndicator_2")
public class MyAbstractHealthIndicator extends AbstractHealthIndicator {

    private static final String VERSION = "V1.0.0";

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        int code = check();
        if(code != 0) {
            builder.down().withDetail("code", code).withDetail("version", VERSION).build();
        }
        builder.withDetail("code", code).withDetail("version", VERSION).up().build();
    }

    private int check() {
        return 0;
    }
}
