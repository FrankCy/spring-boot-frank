package com.frank.distributed.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 *
 *
 * @author cy
 * @version DistributedJobApplication.java, v 0.1 2021年02月08日 3:58 下午 cy Exp $
 */
@SpringBootApplication
// 启动异步调用
@EnableAsync
public class DistributedJobApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributedJobApplication.class, args);
    }

    /**
     * 多线程Scheduled的解决方案
     * @return
     */
    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        // 设置@Scheduled最多线程执行10个
        taskScheduler.setPoolSize(10);
        return taskScheduler;
    }

}
