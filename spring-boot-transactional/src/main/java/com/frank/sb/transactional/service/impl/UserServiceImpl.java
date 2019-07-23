package com.frank.sb.transactional.service.impl;

import com.frank.sb.transactional.dao.mapper.UserMapper;
import com.frank.sb.transactional.entity.po.User;
import com.frank.sb.transactional.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-frank
 * @package: com.frank.sb.transactional.service.impl、
 * @email: cy880708@163.com
 * @date: 2019/7/23 下午4:09
 * @mofified By:
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public int insertSelective(User user) {
        return userMapper.insertSelective(user);
    }
}
