package com.frank.quartz.service.impl;

import com.frank.quartz.config.AbstractTask;
import com.frank.quartz.service.SpiderService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author cy
 * @version $Id: SpiderServiceImpl.java, v 0.1 2020年06月11日 17:45 cy Exp $
 */
@Slf4j
@Service
//@Component("spiderService")
public class SpiderServiceImpl extends AbstractTask implements SpiderService  {

    @Override
    public void spiderGoods(String taskId) {
        log.info("定时爬取任务 {}" , taskId);
    }

    @Override
    protected void executeInternal(JobExecutionContext context) {
        JobDetail jobDetail = context.getJobDetail();
        String name = (String)jobDetail.getJobDataMap().get("name");
        log.info("SpiderServiceImpl ---- executeInternal , {}" , name);
    }
}
