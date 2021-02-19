package com.frank.distributed.job.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 *
 *
 * @author cy
 * @version MyQuartzJob.java, v 0.1 2021年02月18日 3:58 下午 cy Exp $
 */
@Slf4j
public class MyQuartzJob extends QuartzJobBean {

    /**
     * 执行的具体内容
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("MyQuartzJob....");
    }
}
