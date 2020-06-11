package com.frank.quartz.config;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 * @author cy
 * @version $Id: TestTask.java, v 0.1 2020年06月11日 17:11 cy Exp $
 */
@Slf4j
@Component("testTask")
public class TestTask extends AbstractTask {

    @PostConstruct
    public void init() {
        this.cronExpression = "0/2 * * * * ? ";
    }

    @Override
    protected void executeInternal(JobExecutionContext context) {
        log.info("test task start execute.");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            log.info("test task execute interrupted.");
        }
        log.info("test task execute end.");
    }
}