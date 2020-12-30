package com.frank.nacos.api.controller;

import com.frank.nacos.api.util.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 *
 * @author cy
 * @version NacosApiController.java, v 0.1 2020年12月29日 4:54 下午 cy Exp $
 */
@Slf4j
@Controller
@RequestMapping(value = "/nacos")
public class NacosApiController {

    private static final String URL = "http://127.0.0.1:8848/nacos/v1/cs/configs?dataId=abc.yaml&group=DEFAULT_GROUP&tenant=cy-namespace";

    /**
     * 读取yaml配置
     * @return
     */
    @RequestMapping(value = "/findConfig" , method = RequestMethod.GET)
    @ResponseBody
    public String operation() {
        String result = HttpClientUtil.get(URL,"UTF-8");
        log.info("result -> {}", result);
        return result;
    }

}
