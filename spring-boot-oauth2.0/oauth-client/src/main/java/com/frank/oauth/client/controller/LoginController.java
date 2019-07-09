package com.frank.oauth.client.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description：Login Controller
 * @version 1.0
 * @author: Yang.Chang
 * @email: cy880708@163.com
 * @date: 2019/5/27 下午4:54
 * @mofified By:
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private static final Log logger = LogFactory.getLog(LoginController.class);

    @RequestMapping(value = "/index")
    public ModelAndView index() {
        logger.info("LOGIN - - - - - -INDEX");
        //初始化响应模版
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login/index");
        return modelAndView;
    }
}
