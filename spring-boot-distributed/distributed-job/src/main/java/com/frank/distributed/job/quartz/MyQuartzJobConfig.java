package com.frank.distributed.job.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 *
 * @author cy
 * @version MyQuartzJobConfig.java, v 0.1 2021年02月18日 4:01 下午 cy Exp $
 */
@Configuration
public class MyQuartzJobConfig {

    /**
     * 实例化job
     * @return
     */
    @Bean
    public JobDetail jobDetail() {
        JobDetail jobDetail = JobBuilder.newJob(MyQuartzJob.class)
                // 身份
                .withIdentity("job1", "gorup1")
                .storeDurably()
                .build();
        return jobDetail;
    }

    /**
     * 创建触发器，触发实例
     */
    @Bean
    public Trigger trigger() {
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(jobDetail())
                .withIdentity("trigger1", "group1")
                .startNow()
                // 传入表达式
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? "))
                .build();
        return trigger;
    }

}

