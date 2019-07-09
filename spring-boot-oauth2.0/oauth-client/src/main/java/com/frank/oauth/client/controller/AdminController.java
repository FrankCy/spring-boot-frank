package com.frank.oauth.client.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-oauth2.0
 * @package: com.frank.oauth.client.controller、
 * @email: cy880708@163.com
 * @date: 2019/5/28 下午6:44
 * @mofified By:
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private static final Log logger = LogFactory.getLog(AdminController.class);

    @RequestMapping(value = "/welcome")
    public ModelAndView welcome() {
        logger.info("ADMIN - WELCOME");
        //初始化响应模版
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/welcome");

        return modelAndView;
    }

    @RequestMapping(value = "/user/index")
    public ModelAndView index() {
        logger.info("USER - INDEX");
        //初始化响应模版
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/index");
        return modelAndView;
    }

}
