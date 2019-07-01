package com.frank.sb.swagger2.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-frank
 * @package: com.frank.sb.swagger2.controller、
 * @email: cy880708@163.com
 * @date: 2019/7/1 下午2:47
 * @mofified By:
 */
@Api(value="/test", tags="测试接口模块")
@RestController
@RequestMapping("/test")
public class CrackController {

    @GetMapping("/test")
    public JSONObject crack(){
        JSONObject json = new JSONObject();
        json.put("validTo", Long.parseLong("111111111111111"));
        json.put("valid", true);
        return json;
    }

    @GetMapping("/")
    public JSON index(){
        JSONObject json = new JSONObject();
        json.put("aaa", Long.parseLong("111111111111111"));
        json.put("valid", true);
        return json;
    }

}