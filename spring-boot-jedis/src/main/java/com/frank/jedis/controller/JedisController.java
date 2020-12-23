package com.frank.jedis.controller;

import com.alibaba.fastjson.JSONObject;
import com.frank.jedis.util.JedisUtil;
import com.frank.jedis.vo.JedisVO;
import com.ubirch.util.uuid.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @version JedisController.java, v 0.1 2020年12月23日 2:01 下午 cy Exp $
 */
@Slf4j
@Controller
@RequestMapping(value = "/jedis")
public class JedisController {

    @Autowired
    private JedisUtil jedisUtil;

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
    public String operation(@RequestBody JedisVO jedisVO) {
        String operationFlag = jedisVO.getOperationFlag();
        if(StringUtils.isEmpty(operationFlag)) {
            return "operationFlag 不能为空";
        }
        if(INSERT.equals(operationFlag)) {
            return insert(jedisVO);
        } else
        if(FIND.equals(operationFlag)) {
            return find(jedisVO);
        } else
        if(UPDATE.equals(operationFlag)) {
            return update(jedisVO);
        } else
        if(DELETE.equals(operationFlag)) {
            return delete(jedisVO);
        }

        return "操作成功";
    }

    /**
     * 新增
     * @return
     */
    public String insert(JedisVO jedisVO) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", UUIDUtil.uuidStr());
        jsonObject.put("name", "bill");
        jsonObject.put("tel", "13414414141414");
        String key = jedisVO.getKey();
        String jsonString = jsonObject.toJSONString();
        jedisUtil.set(key, jsonString);
        log.info("insert \nKey -> {} \nvalue -> {} ", key, jsonString);
        return jsonString;
    }

    /**
     * 查询
     * @param jedisVO
     * @return
     */
    public String find(JedisVO jedisVO) {
        return jedisUtil.get(jedisVO.getKey());
    }

    /**
     * 更新
     * @return
     */
    public String update(JedisVO jedisVO) {
        String key = jedisVO.getKey();
        if(jedisUtil.exists(key)) {
            log.info("修改前：{}", jedisUtil.get(key).toString());
            jedisUtil.set(key, "修改后");
            log.info("修改后：{}", jedisUtil.get(key).toString());
        } else {
            return "缓存中没有找到KEY -> " + key + " 对应的数据，修改个吊毛";
        }
        return "修改成功";
    }

    /**
     * 删除
     * @return
     */
    public String delete(JedisVO jedisVO) {
        String key = jedisVO.getKey();
        if(jedisUtil.exists(key)) {
            jedisUtil.del(key);
            log.info("删除对象{}", key);
            return "删除成功";
        } else {
            return "缓存中没有找到KEY -> " + key + " 对应的数据，删除失败";
        }
    }

}
