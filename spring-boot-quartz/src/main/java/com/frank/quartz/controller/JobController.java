package com.frank.quartz.controller;

import com.frank.quartz.config.QuartzManager;
import com.frank.quartz.config.TestTask;
import com.frank.quartz.service.QuartzService;
import com.frank.quartz.util.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author cy
 * @version $Id: JobController.java, v 0.1 2020年06月11日 16:55 cy Exp $
 */
@Slf4j
@RestController
public class JobController {

    @Autowired
    private QuartzService quartzService;

    @Autowired
    private QuartzManager quartzManager;

    @Autowired
    private TestTask testTask;

    /**
     * 创建job
     * @return
     */
    @RequestMapping(value = "/addJob", method = RequestMethod.GET)
    public ApiResult addJob() {
        if(quartzManager.addJob("testTask", testTask.getClass().getName(), "0/3 * * * * ?")) {
            return ApiResult.success("新增任务成功");
        } else {
            return ApiResult.failure("新增任务失败");
        }
    }

    /**
     * 修改Job
     * @return
     */
    @RequestMapping(value = "/updateJob", method = RequestMethod.GET)
    public ApiResult updateJbo() {
        if(quartzManager.updateJob("testTask", "0/5 * * * * ?")) {
            return ApiResult.success("修改任务成功");
        } else {
            return ApiResult.failure("修改任务失败");
        }
    }

    /**
     * 删除job
     * @return
     */
    @RequestMapping(value = "/deleteJob", method = RequestMethod.GET)
    public ApiResult deleteJob(String jobName) {
        if(quartzManager.deleteJob(jobName)) {
            return ApiResult.success("删除任务成功");
        } else {
            return ApiResult.failure("删除化任务失败");
        }
    }

    /**
     * 动态创建爬虫任务
     * @return
     */
    @RequestMapping(value = "/addSpiderJob", method = RequestMethod.GET)
    public ApiResult addSpiderJob(String jobName, String cron) {
        if(quartzService.settingSpiderTask(jobName, cron)) {
            return ApiResult.success("定时任务设置成功，规则为："+ cron);
        } else {
            return ApiResult.failure("定时任务任务设置失败");
        }
    }


}
