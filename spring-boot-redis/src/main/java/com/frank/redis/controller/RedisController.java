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
     * 新增操作
     */
    private static String INSERT = "c";

    /**
     * 查询操作
     */
    private static String FIND = "r";

    /**
     * 更新操作
     */
    private static String UPDATE = "u";

    /**
     * 删除操作
     */
    private static String DELETE = "d";

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
        if(INSERT.equals(operationFlag)) {
            return insert(redisTestVO);
        } else
        if(FIND.equals(operationFlag)) {
            return find(redisTestVO);
        } else
        if(UPDATE.equals(operationFlag)) {
            return update(redisTestVO);
        } else
        if(DELETE.equals(operationFlag)) {
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
        return String.valueOf(redisUtil.get(redisTestVO.getKey()));
    }

    /**
     * 更新
     * @return
     */
    public String update(RedisTestVO redisTestVO) {
        String key = redisTestVO.getKey();
        if(redisUtil.hasKey(key)) {
            log.info("修改前：{}", redisUtil.get(key).toString());
            redisUtil.set(key, "修改后");
            log.info("修改后：{}", redisUtil.get(key).toString());
        } else {
            return "缓存中没有找到KEY -> " + key + " 对应的数据，修改个吊毛";
        }
        return "修改成功";
    }

    /**
     * 删除
     * @return
     */
    public String delete(RedisTestVO redisTestVO) {
        String key = redisTestVO.getKey();
        if(redisUtil.hasKey(key)) {
            redisUtil.del(key);
            log.info("删除对象{}", key);
            return "删除成功";
        } else {
            return "缓存中没有找到KEY -> " + key + " 对应的数据，删除失败";
        }
    }

}
