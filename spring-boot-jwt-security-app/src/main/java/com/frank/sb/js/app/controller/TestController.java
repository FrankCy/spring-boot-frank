package com.frank.sb.js.app.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-frank
 * @package: com.frank.sb.js.app.controller、
 * @email: cy880708@163.com
 * @date: 2019/7/4 下午1:48
 * @mofified By:
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    private static final Log logger = LogFactory.getLog(TestController.class);

    @RequestMapping(value = "/index")
    public ModelAndView index() {
        //初始化响应模版
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test/index");
        return modelAndView;
    }
}
