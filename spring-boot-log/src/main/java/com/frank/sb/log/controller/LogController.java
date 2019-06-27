package com.frank.sb.log.controller;

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
 * @package: com.frank.sb.log.controller、
 * @email: cy880708@163.com
 * @date: 2019/6/27 下午3:11
 * @mofified By:
 */
@Controller
@RequestMapping(value = "/admin")
public class LogController {

    private static final Log logger = LogFactory.getLog(LogController.class);

    @RequestMapping(value = "/index")
    public ModelAndView index() {
        //初始化响应模版
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/index");
        return modelAndView;
    }
}
