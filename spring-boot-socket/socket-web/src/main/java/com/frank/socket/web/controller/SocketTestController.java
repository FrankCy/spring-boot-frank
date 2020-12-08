package com.frank.socket.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 *
 * @author cy
 * @version SocketTestController.java, v 0.1 2020年12月07日 4:38 下午 cy Exp $
 */
@Slf4j
@Controller
@RequestMapping(value = "/socket")
public class SocketTestController {

    @RequestMapping(value = "/test")
    public ModelAndView index() {
        log.info("进入socket -> test");
        //初始化响应模版
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("frank", "常生");
        modelAndView.setViewName("socket/socket");
        return modelAndView;
    }
}
