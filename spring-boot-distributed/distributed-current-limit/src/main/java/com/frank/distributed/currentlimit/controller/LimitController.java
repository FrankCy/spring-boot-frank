package com.frank.distributed.currentlimit.controller;

import com.frank.distributed.currentlimit.service.LimiterService;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author cy
 * @version LimitController.java, v 0.1 2021年02月19日 4:53 下午 cy Exp $
 */
@RestController
@Slf4j
public class LimitController {

    // 创建可放2令牌的桶且每秒放2令牌，0.5秒放1令牌
    private RateLimiter rateLimiter = RateLimiter.create(2);

    @GetMapping("/guava")
    public void guava() {
        // 平滑输出,允许突发流量
        //log.info("{}", rateLimiter.acquire(3));
        //log.info("{}", rateLimiter.acquire());
        //log.info("{}", rateLimiter.acquire());
        //log.info("{}", rateLimiter.acquire());
        //log.info("{}", rateLimiter.acquire());

        boolean tryAcquire = rateLimiter.tryAcquire();
        if(tryAcquire) {
            log.info("恭喜，抢到了 ");
        } else {
            log.info("不好意思，没抢到");
        }

    }

    /**
     * 直接在控制台就可以对controller api进行限流，通过自定义限流异常返回给用户信息
     * @return
     */
    @GetMapping("/sentinel")
    public String sentinel() {
        return "sentinel";
    }

    @Autowired
    private LimiterService limiterService;

    @GetMapping("/sentinelForService")
    public String sentinelForService() {
        return limiterService.process();
    }


}
