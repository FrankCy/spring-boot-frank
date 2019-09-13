package com.frank.sb.redis.controller;

import com.frank.sb.redis.bean.User;
import com.frank.sb.redis.util.BaseUtil;
import com.frank.sb.redis.util.JsonUtil;
import com.frank.sb.redis.util.RedisUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-redis
 * @package: com.sbr.test.controller、
 * @email: cy880708@163.com
 * @date: 2019/1/4 下午1:41
 * @mofified By:
 */
@Controller
@RequestMapping(value = "redis")
public class RedisController {

    @Autowired
    private RedisUtil redisUtil;

    /**
     *打印日志
     */
    private static final Log logger = LogFactory.getLog(RedisController.class);

    @RequestMapping (value = "index")
    public ModelAndView index(@Param("flag") String flag) {

        ModelAndView modelAndView = new ModelAndView();
        String userJson = "";

        if(!StringUtils.isEmpty(flag)) {
            if("update".equals(flag)) {
                if(redisUtil.hasKey("user_json")) {
                    logger.info("修改前user_json：" + redisUtil.get("user_json").toString());
                    redisUtil.set("user_json", "我给改了");
                    logger.info("修改后user_json：" + redisUtil.get("user_json").toString());
                } else {
                    logger.info("未找到对应对象，无法修改");
                }
            } else
            if("delete".equals(flag)) {
                redisUtil.del("user_json");
                logger.info("删除对象[user_json]");
            } else
            if("select".equals(flag)) {
                if(redisUtil.hasKey("user_json")) {
                    Object userJsonObj = redisUtil.get("user_json");
                    userJson = userJsonObj.toString();
                    //获取并转换
                    logger.info("查询缓存[user_json] ： " + userJson);
                } else {
                    logger.info("未找到对应对象，查询失败");
                }
            } else
            if("insert".equals(flag)) {
                //插入
                User user = new User();
                user.setId(BaseUtil.getUUID());
                user.setName("frank");
                user.setTel("13843838438");

                userJson = JsonUtil.beanToJson(user);
                redisUtil.set("user_json", userJson);
                logger.info("新增[user_json] ： " + userJson);
            }
        } else {
            logger.info("no flag");
        }

        modelAndView.setViewName("index");
        modelAndView.addObject("userJson", userJson);
        return modelAndView;
    }

}
