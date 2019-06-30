package com.frank.sb.actuator.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("frankHealthIndicator_1")
public class MyHealthIndicator implements HealthIndicator {

    private static final String VERSION = "V1.0.0";

    /**
     * 自定义检测check函数内容是否为0的例子。
     * 我们可以访问
     * @return
     */
    @Override
    public Health health() {
        // 获取自定义check内容
        int code = check();
        // 当check不等于0时，DOWN：代表运行错误
        if(code != 0) {
            Health.down().withDetail("code", code).withDetail("version", VERSION).build();
        }
        // 当check结果为0时，UP：代表运行正常
        return  Health.up().withDetail("code", code).withDetail("version", VERSION).up().build();
    }

    private int check() {


        return 0;
    }
}


