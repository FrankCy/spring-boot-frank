package com.frank.oauth.server.impl;

import com.frank.oauth.entity.po.User;
import com.frank.oauth.server.mapper.UserMapper;
import com.frank.oauth.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-oauth2.0
 * @package: com.frank.oauth.server.impl、
 * @email: cy880708@163.com
 * @date: 2019/5/27 下午5:10
 * @mofified By:
 */
@Service("userService")
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByPrimaryKey(String id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public User selectByName(String name) {
        User user = userMapper.selectByUserName(name);
        return user;
    }
}
