package com.frank.distributed.job.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author cy
 * @version Process.java, v 0.1 2021年02月18日 3:30 下午 cy Exp $
 */
@Slf4j
@Component
public class Process {

    @Async
    public void doProcess1() throws InterruptedException {
        log.info("doProcess1 ....start");
        Thread.sleep(5000);
        log.info("doProcess1 ....end");
    }

}
