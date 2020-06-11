package com.frank.quartz.controller;

import com.frank.quartz.util.ApiResult;
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
@RestController
public class JobController {

    @Autowired
    //private QuartzManager quartzManager;
    /**
     * @description：初始化所有任务
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/3/20 下午2:25
     * @mofified By:
     */
    @RequestMapping(value = "/initJob", method = RequestMethod.GET)
    public ApiResult initJob() {
        //if(quartzManager.addJob(Constants.JOB_INIT_INIT_JOB, Constants.JOB_INIT_INI_JOB, Constants.JOB_INIT_CRON_EXP)) {
        //    return ApiResult.success("初始化任务成功");
        //} else {
            return ApiResult.failure("初始化任务失败");
        //}
    }

}
