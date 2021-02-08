package com.frank.distributed.session.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 * @author cy
 * @version UserController.java, v 0.1 2021年02月02日 2:56 下午 cy Exp $
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @PostMapping("/login")
    public String login(@RequestParam String userName, @RequestParam String password, HttpSession session) {
        // 账号密码正确
        // **session是由tomcat管理的，不是服务器管理的**
        session.setAttribute("login_user", userName);
        return "登录成功";
    }

    @GetMapping("/info")
    public String info(HttpSession session) {
        return "当前登录的是：" + session.getAttribute("login_user");
    }


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 使用Token
     * @param userName
     * @param password
     * @param session
     * @return
     */
    @GetMapping("/loginWithToken")
    public String loginWithToken(@RequestParam String userName, @RequestParam String password, HttpSession session) {
        // 账号密码正确
        String key = "token_" + UUID.randomUUID().toString();
        stringRedisTemplate.opsForValue().set(key, userName, 3600, TimeUnit.SECONDS);
        return key;
    }

    /**
     * 获取Token(从请求中获取)
     * @param token
     * @return
     */
    @GetMapping("/infoWithToken")
    public String infoWithToken(@RequestParam String token) {
        return "当前登录的是：" + stringRedisTemplate.opsForValue().get(token);
    }

    /**
     * 获取Token（从header中获取）
     * @param token
     * @return
     */
    @GetMapping("/infoWithTokenForHeader")
    public String infoWithTokenForHeader(@RequestHeader String token) {
        return "当前登录的是：" + stringRedisTemplate.opsForValue().get(token);
    }

}
