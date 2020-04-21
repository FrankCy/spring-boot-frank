package com.frank.sb.jpa.controller;

import com.frank.sb.jpa.entity.User;
import com.frank.sb.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @ProjectName: spring-boot-frank
 * @Package: com.frank.sb.jpa.controller
 * @ClassName: HelloController
 * @Author: cy
 * @Description: ${description}
 * @Date: 2020-04-21 18:22
 */
@RestController
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/getUser")
    public Optional<User> getUser(String id) {
        return userService.selectUser(id);
    }

    @RequestMapping(value = "/user/saveUser")
    public User saveUser() {
        User user = userService.insertUser("没用上");
        return user;
    }

}
