package com.frank.redis.controller;

import com.alibaba.fastjson.JSON;
import com.frank.redis.pojo.User;
import com.frank.redis.util.RedisUtil;
import com.frank.redis.vo.RedisTestVO;
import com.ubirch.util.uuid.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 *
 * @author cy
 * @version RedisController.java, v 0.1 2020年12月15日 11:59 上午 cy Exp $
 */
@Slf4j
@Controller
@RequestMapping(value = "/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 新增
     * @return
     */
    @RequestMapping(value = "/operation" , method = RequestMethod.POST)
    @ResponseBody
    public String operation(@RequestBody RedisTestVO redisTestVO) {
        String operationFlag = redisTestVO.getOperationFlag();
        if(StringUtils.isEmpty(operationFlag)) {
            return "operationFlag 不能为空";
        }
        if("c".equals(operationFlag)) {
            return insert(redisTestVO);
        } else
        if("r".equals(operationFlag)) {
            return find(redisTestVO);
        } else
        if("u".equals(operationFlag)) {
            return update(redisTestVO);
        } else
        if("d".equals(operationFlag)) {
            return delete(redisTestVO);
        }

        return "操作成功";
    }

    /**
     * 新增
     * @return
     */
    public String insert(RedisTestVO redisTestVO) {
        //插入
        User user = new User();
        user.setId(UUIDUtil.uuidStr());
        user.setName("bill");
        user.setTel("13843838438");
        String jsonString = JSON.toJSONString(user);
        String key = redisTestVO.getKey();
        redisUtil.set(key, jsonString);
        log.info("insert \nKey -> {} \nvalue -> {} ", key, jsonString);
        return jsonString;
    }

    /**
     * 查询
     * @param redisTestVO
     * @return
     */
    public String find(RedisTestVO redisTestVO) {
        return "";
    }

    /**
     * 更新
     * @return
     */
    public String update(RedisTestVO redisTestVO) {
        return "";
    }

    /**
     * 删除
     * @return
     */
    public String delete(RedisTestVO redisTestVO) {
        return "";
    }

}
