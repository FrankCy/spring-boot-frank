package com.frank.redisson.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 *
 * @author cy
 * @version RedissonController.java, v 0.1 2020年12月24日 11:45 上午 cy Exp $
 */
@Slf4j
@Controller
@RequestMapping(value = "/redisson")
public class RedissonController {

    @Autowired
    //private RedissonClient redissonClient;

    /**
     * 锁练习
     * @return
     */
    @RequestMapping(value = "/lockDemo" , method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        //RLock lock = redissonClient.getLock(lockKey);
        //try {
        //    lock.lock();
        //    Thread.sleep(10000);
        //} catch (Exception e) {
        //
        //} finally {
        //    lock.unlock();
        //}
        return "已解锁";
    }

}