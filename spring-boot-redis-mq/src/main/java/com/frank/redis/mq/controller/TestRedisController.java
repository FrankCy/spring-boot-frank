package com.frank.redis.mq.controller;

import com.frank.redis.mq.config.RedisMq;
import com.frank.redis.mq.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 *
 * @author cy
 * @version TestRedisController.java, v 0.1 2021年03月12日 5:50 下午 cy Exp $
 */
@Slf4j
@Controller
@RequestMapping(value = "/redis")
public class TestRedisController {

    @Autowired
    RedisMq redisMq;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 在redis中存储消息
     * @param msg
     * @return
     */
    @RequestMapping(value = "/push" , method = RequestMethod.POST)
    @ResponseBody
    public String pushMsg(@RequestParam("msg")String msg){
        //redisUtil.set(key, jsonString);


        redisMq.push(msg);
        return "操作成功";
    }

    /**
     * 从redis中获取消息
     * @return
     */
    @GetMapping("/pop")
    public Object popMsg(){
        return redisMq.pop();
    }

}
