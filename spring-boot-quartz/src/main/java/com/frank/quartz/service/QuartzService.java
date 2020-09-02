package com.frank.quartz.service;

/**
 *
 *
 * @author cy
 * @version $Id: QuartzService.java, v 0.1 2020年06月11日 17:49 cy Exp $
 */
public interface QuartzService {

    boolean settingSpiderTask(String jobName, String cron);

}
