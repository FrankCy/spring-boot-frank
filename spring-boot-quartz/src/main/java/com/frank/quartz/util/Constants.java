package com.frank.quartz.util;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-quartz
 * @package: com.sb.quartz.util、
 * @email: cy880708@163.com
 * @date: 2019/3/20 下午5:59
 * @mofified By:
 */
public class Constants {

    /**
     * 默认启动定时主键
     */
    public static final String JOB_INIT_INIT_JOB = "initJob";

    /**
     * 默认定时组名称
     */
    public static final String JOB_DEFAULT_GROUP_NAME = "JOB_DEFAULT_GROUP_NAME";

    /**
     * 默认激活组名称
     */
    public static final String TRIGGER_DEFAULT_GROUP_NAME = "TRIGGER_DEFAULT_GROUP_NAME";

    /**
     * 默认启动定时主键
     */
    public static final String JOB_PARAM = "paramJob";

    /**
     * 带参数定时触发器
     */
    public static final String PARAM_JOB_SERVICE_TRIGGER = "com.sb.quartz.job.ParamJob";
    /**
     * 带参数定时任务Cron
     */
    public static final String PARAM_JOB_CRON_EXP = "*/10 * * * * ?";

    /**
     * 初始化定时任务实体
     */
    public static final String JOB_INIT_INI_JOB = "com.sb.quartz.job.JobInit";

    /**
     * 5s/次
     */
    public static final String JOB_INIT_CRON_EXP = "*/5 * * * * ?";
}
