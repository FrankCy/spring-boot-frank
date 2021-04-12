package com.frank.redis.mq.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 * @author cy
 * @version RedisMq.java, v 0.1 2021年03月12日 5:49 下午 cy Exp $
 */
@Component
public class RedisMq {

    private static String key = "redis-test";

    @Autowired
    RedisConnectionFactory mConnectionFactory;

    private StringRedisTemplate redisTemplate;

    /**
     * 初始化redis
     */
    @PostConstruct
    public void postInit() {
        redisTemplate = new StringRedisTemplate(mConnectionFactory);
    }

    /**
     * 发送消息
     * @param message
     */
    public void push(String message){
        redisTemplate.opsForList().leftPush(key,message);
    }

    /**
     * 发送消息
     * @param message
     */
    public void push(String key, String message){
        redisTemplate.opsForList().rightPush(key,message);
    }

    /**
     * 获取消息,可以对消息进行监听，没有超过监听事件，则返回消息为null
     * rightPop：1.key,2.超时时间，3.超时时间类型
     * @return
     */
    public String pop(){
        return redisTemplate.opsForList().rightPop(key,60, TimeUnit.SECONDS);
    }
}
