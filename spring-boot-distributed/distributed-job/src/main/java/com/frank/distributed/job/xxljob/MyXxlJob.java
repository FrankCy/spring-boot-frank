package com.frank.distributed.job.xxljob;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author cy
 * @version MyXxlJob.java, v 0.1 2021年02月19日 11:25 上午 cy Exp $
 */
@Component
@Slf4j
public class MyXxlJob {
    @XxlJob("MyXxlJobHandler")
    public ReturnT<String> execute(String param) {
        log.info("MyXxlJobHandler execute...");
        XxlJobLogger.log("MyXxlJobHandler execute...");
        return ReturnT.SUCCESS;
    }
}
