package com.frank.distributed.currentlimit.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.frank.distributed.currentlimit.service.LimiterService;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author cy
 * @version LimiterServiceImpl.java, v 0.1 2021年02月20日 11:12 上午 cy Exp $
 */
@Service
public class LimiterServiceImpl implements LimiterService {

    /**
     * 通过注解@SentinelResource实现sevice限流
     * @return
     */
    @SentinelResource("LimiterService.process")
    @Override
    public String process() {
        return "process";
    }

}
