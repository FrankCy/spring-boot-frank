package com.frank.sb.jpa.service;

import com.frank.sb.jpa.entity.User;

import java.util.Optional;

/**
 * @ProjectName: spring-boot-frank
 * @Package: com.frank.sb.jpa.service
 * @ClassName: UserService
 * @Author: cy
 * @Description: ${description}
 * @Date: 2020-04-21 18:24
 */
public interface UserService {

    /**
     * @Method insertUser
     * @Author cy
     * @Version  1.0
     * @Description
     * @param var
     * @Return
     * @Date 2020-04-21
     */
    User insertUser(String var);

    /**
     * @Method selectUser
     * @Author cy
     * @Version  1.0
     * @Description
     * @param id
     * @Return
     * @Date 2020-04-21
     */
    Optional<User> selectUser(String id);
}
