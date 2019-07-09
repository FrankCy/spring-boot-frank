package com.frank.oauth.server.impl;

import com.frank.oauth.entity.po.UserRole;
import com.frank.oauth.server.mapper.UserRoleMapper;
import com.frank.oauth.server.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-oauth2.0
 * @package: com.frank.oauth.server.impl、
 * @email: cy880708@163.com
 * @date: 2019/5/28 下午3:26
 * @mofified By:
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public UserRole selectByName(String id) {
        UserRole userRole = userRoleMapper.selectByPrimaryKey(id);
        return userRole;
    }
}
