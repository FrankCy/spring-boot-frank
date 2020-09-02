package com.frank.quartz.config;

import lombok.extern.slf4j.Slf4j;
import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *
 *
 * @author cy
 * @version $Id: QuartzManager.java, v 0.1 2020年06月11日 17:09 cy Exp $
 */
@Slf4j
@Component
@Scope("singleton")
public class QuartzManager implements ApplicationContextAware {

    private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();

    private static final String JOB_DEFAULT_GROUP_NAME = "JOB_DEFAULT_GROUP_NAME";

    private static final String TRIGGER_DEFAULT_GROUP_NAME = "TRIGGER_DEFAULT_GROUP_NAME";

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private AutowiringSpringBeanJobFactory autowiringSpringBeanJobFactory;

    public void start() {
        //启动所有任务
        try {
            this.scheduler = schedulerFactory.getScheduler();
            scheduler.setJobFactory(autowiringSpringBeanJobFactory);
            //启动所有任务,这里获取AbstractTask的所有子类
            Map<String, AbstractTask> tasks = applicationContext.getBeansOfType(AbstractTask.class);
            tasks.forEach((k, v) -> {
                String cronExpression = v.getCronExpression();
                if (cronExpression != null) {
                    addJob(k, v.getClass().getName(), cronExpression);
                }
            });
            log.info("start jobs finished.");
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException("init Scheduler failed");
        }
    }

    public boolean addJob(String jobName, String jobClass, String cronExp) {
        boolean result = false;
        if (!CronExpression.isValidExpression(cronExp)) {
            log.error("Illegal cron expression format({})", cronExp);
            return result;
        }
        try {
            JobDetail jobDetail = JobBuilder.newJob().withIdentity(new JobKey(jobName, JOB_DEFAULT_GROUP_NAME))
                    .ofType((Class<Job>) Class.forName(jobClass))
                    .build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .forJob(jobDetail)
                    .withSchedule(CronScheduleBuilder.cronSchedule(cronExp))
                    .withIdentity(new TriggerKey(jobName, TRIGGER_DEFAULT_GROUP_NAME))
                    .build();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            log.error("QuartzManager add job failed");
        }
        return result;
    }

    public boolean updateJob(String jobName, String cronExp) {
        boolean result = false;
        if (!CronExpression.isValidExpression(cronExp)) {
            log.error("Illegal cron expression format({})", cronExp);
            return result;
        }
        JobKey jobKey = new JobKey(jobName, JOB_DEFAULT_GROUP_NAME);
        TriggerKey triggerKey = new TriggerKey(jobName, TRIGGER_DEFAULT_GROUP_NAME);
        try {
            if (scheduler.checkExists(jobKey) && scheduler.checkExists(triggerKey)) {
                JobDetail jobDetail = scheduler.getJobDetail(jobKey);
                Trigger newTrigger = TriggerBuilder.newTrigger()
                        .forJob(jobDetail)
                        .withSchedule(CronScheduleBuilder.cronSchedule(cronExp))
                        .withIdentity(new TriggerKey(jobName, TRIGGER_DEFAULT_GROUP_NAME))
                        .build();
                scheduler.rescheduleJob(triggerKey, newTrigger);
                result = true;
            } else {
                log.error("update job name:{},group name:{} or trigger name:{},group name:{} not exists..",
                        jobKey.getName(), jobKey.getGroup(), triggerKey.getName(), triggerKey.getGroup());
            }
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
            log.error("update job name:{},group name:{} failed!", jobKey.getName(), jobKey.getGroup());
        }
        return result;
    }

    public boolean deleteJob(String jobName) {
        boolean result = false;
        JobKey jobKey = new JobKey(jobName, JOB_DEFAULT_GROUP_NAME);
        try {
            if (scheduler.checkExists(jobKey)) {
                result = scheduler.deleteJob(jobKey);
            } else {
                log.error("delete job name:{},group name:{} not exists.", jobKey.getName(), jobKey.getGroup());
            }
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
            log.error("delete job name:{},group name:{} failed!", jobKey.getName(), jobKey.getGroup());
        }
        return result;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
