package com.frank.distributed.job.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author cy
 * @version MyJob.java, v 0.1 2021年02月18日 2:46 下午 cy Exp $
 */
@Slf4j
// 被spring管理
@Component
// 声明启动调度（当启动时，才会生效，加到类只对类有效，加到启动类，即对目录下使用调度的注解函数@Scheduled都生效）
//@EnableScheduling
public class MyJob {

    /**
     * 单线程demo
     */
    // 每3秒打印一次
    //@Scheduled(fixedDelay = 3000)
    // 每3秒打印一次(initialDelay代表启动后5秒再生效）
    // fixedDelay 固定延迟，时间间隔是前次任务的结束，到下次任务到开始
    //@Scheduled(fixedDelayString = "3000", initialDelay = 5000)
    // fixedRate 时间间隔是前次任务和下次任务到开始
    //@Scheduled(fixedRate = 3000, initialDelay = 5000)
    // crontab http://cron.qqe2.com 表达式（可以配置很复杂到定时任务）
    @Scheduled(cron = "* * * * * ?")
    public void process() {
        // 测试程序
        log.info("非分布式任务 Scheduled 的调试。。。。process。。。。start。。。。");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("非分布式任务 Scheduled 的调试。。。。process。。。。end。。。。");
    }

    /**
     * 多线程 demo start （运行时将process()注释）
     */
    @Scheduled(fixedRate = 3000)
    public void process1() throws InterruptedException {
        log.info("process1 ....start");
        Thread.sleep(5000);
        log.info("process1 ....end");
    }

    @Scheduled(fixedRate = 3000)
    public void process2() throws InterruptedException {
        log.info("process2 ....start");
        Thread.sleep(5000);
        log.info("process2 ....end");
    }
    /**
     * 多线程 demo end
     */

    @Autowired
    private Process process;

    /**
     * 无论中间执行多久，都是每3秒执行一次
     * @throws InterruptedException
     */
    @Async
    public void doProcess1() throws InterruptedException {
        process.doProcess1();
    }

}
