package com.frank.sb.js.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DemoController {

    // 根目录映射 Get访问方式 直接返回一个字符串
    @RequestMapping("/")
    public static Map<String, String> hello() {
        // 返回map会变成JSON key value方式
        Map<String,String> map=new HashMap<String,String>();
        map.put("content", "hello freewolf~");
        return map;
    }

}
