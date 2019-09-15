package com.frank.sb.junit.controller;

import com.frank.sb.junit.service.JunitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-frank
 * @package: com.frank.sb.junit.controller、
 * @email: cy880708@163.com
 * @date: 2019/9/15 下午4:12
 * @mofified By:
 */
@Controller
@RequestMapping(value = "/junit")
public class JunitTestController {

    @Autowired
    private JunitService junitService;

    @RequestMapping(value = "/helloJunit")
    public ModelAndView helloJunit() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", junitService.junitTestServiceString("Frank"));
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
