package com.frank.boot.custom.maven.action.controller;

import com.frank.boot.custom.maven.action.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 *
 * @author cy
 * @version DemoController.java, v 0.1 2020年09月03日 19:02 cy Exp $
 */
@Controller
@RequestMapping(value = "/demo")
public class DemoController {

    @Autowired
    private ActionService actionService;

    @RequestMapping(value = "/sendMaill")
    public String welcome() {
        actionService.sendMail("cy880708@163.com", "主题：测试邮件发送", "测试邮件发送是否可用");
        return "调用了";
    }

}
