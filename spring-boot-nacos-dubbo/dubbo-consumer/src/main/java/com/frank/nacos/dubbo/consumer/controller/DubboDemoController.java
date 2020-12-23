package com.frank.nacos.dubbo.consumer.controller;

import com.frank.nacos.dubbo.api.service.DubboDemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 *
 * @author cy
 * @version StorageController.java, v 0.1 2020年09月16日 16:47 cy Exp $
 */
@Slf4j
@Controller
@RequestMapping(value = "/dubbo")
public class DubboDemoController {

    @Reference
    private DubboDemoService dubboDemoService;

    @RequestMapping(value = "/demo" , method = RequestMethod.GET)
    @ResponseBody
    public String Demo() {
        return "服务器返回内容：" + dubboDemoService.helloDubbo("客户端最帅!");
    }


}