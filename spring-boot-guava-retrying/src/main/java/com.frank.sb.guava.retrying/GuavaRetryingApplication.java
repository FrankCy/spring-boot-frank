package com.frank.sb.guava.retrying;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 *
 * @author cy
 * @version $Id: GuavaRetryingApplication.java, v 0.1 2020年05月20日 10:33 cy Exp $
 */
@SpringBootApplication
@EnableScheduling
@EnableRetry //
public class GuavaRetryingApplication {
    public static void main(String[] args) {
        SpringApplication.run(GuavaRetryingApplication.class, args);
    }
}
