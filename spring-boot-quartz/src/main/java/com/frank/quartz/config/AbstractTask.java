package com.frank.quartz.config;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

/**
 *
 *
 * @author cy
 * @version $Id: AbstractTask.java, v 0.1 2020年06月11日 17:10 cy Exp $
 */
@Slf4j
public abstract class AbstractTask implements Job {

    protected abstract void executeInternal(JobExecutionContext context);

    protected String cronExpression;

    @Override
    public void execute(JobExecutionContext context) {
        try {
            executeInternal(context);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            log.error("job execute failed!");
        }
    }

    public String getCronExpression() {
        return cronExpression;
    }
}

