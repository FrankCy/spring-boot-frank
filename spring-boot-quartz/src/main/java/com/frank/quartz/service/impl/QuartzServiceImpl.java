package com.frank.quartz.service.impl;

import com.frank.quartz.config.QuartzManager;
import com.frank.quartz.service.QuartzService;
import com.frank.quartz.service.SpiderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author cy
 * @version $Id: QuartzServiceImpl.java, v 0.1 2020年06月11日 17:49 cy Exp $
 */
@Slf4j
@Service
public class QuartzServiceImpl implements QuartzService {

    @Autowired
    private SpiderService spiderService;

    @Autowired
    private QuartzManager quartzManager;

    @Override
    public boolean settingSpiderTask(String cron) {
        if(quartzManager.addJob("spiderTask", spiderService.getClass().getName(), cron)) {
            return true;
        }
        return false;
    }
}
