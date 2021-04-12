package com.frank.redis.mq.controller;

import com.frank.redis.mq.config.RedisMq;
import com.frank.redis.mq.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
     * @param key
     * @param url
     * @param goodsId
     * @param fid
     * @return
     */
    @RequestMapping(value = "/push" , method = RequestMethod.POST)
    @ResponseBody
    public String pushMsg(@RequestParam("key") String key,
                          @RequestParam("url") String url,
                          @RequestParam("flg") String flg,
                          @RequestParam("goodsId") String goodsId,
                          @RequestParam("fid") String fid,
                          @RequestParam("callbackUrl") String callbackUrl,
                          @RequestParam("spiderCount") String spiderCount){
        // 插入队列信息
        redisMq.push(key, url);

        // 插入redis基础信息
        StringBuffer param = new StringBuffer(160)
                // 0：检索；1：详情
                .append(flg).append(",")
                // 任务ID
                .append("xxx").append(",")
                // 商品ID
                .append(StringUtils.isEmpty(goodsId) ? "FFF0" : goodsId).append(",")
                // 网站ID
                .append("xxx").append(",")
                // 站点ID
                .append("xxx").append(",")
                // 国家标识
                .append("xxx").append(",")
                // 获取条数
                .append(Integer.parseInt(spiderCount)).append(",")
                // 回调地址
                .append(callbackUrl).append(",")
                // 数据类型
                .append("1").append(",")
                // 父ID
                .append(StringUtils.isEmpty(fid) ? "FFF0" : fid).append(",")
                // URL
                .append(url);

        redisMq.push(key+"-par", param.toString());
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
