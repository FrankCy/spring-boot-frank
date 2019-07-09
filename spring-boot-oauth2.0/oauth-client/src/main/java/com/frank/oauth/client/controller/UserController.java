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
 * @date: 2019/5/28 下午8:05
 * @mofified By:
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static final Log logger = LogFactory.getLog(UserController.class);

    @RequestMapping(value = "/index")
    public String tableTestFm() {
        logger.info("USER - INDEX");
        return "user/index";
    }

}