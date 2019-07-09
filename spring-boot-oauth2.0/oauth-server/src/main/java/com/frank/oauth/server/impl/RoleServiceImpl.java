package com.frank.oauth.server.impl;

import com.frank.oauth.entity.po.Role;
import com.frank.oauth.server.mapper.RoleMapper;
import com.frank.oauth.server.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-oauth2.0
 * @package: com.frank.oauth.server.impl、
 * @email: cy880708@163.com
 * @date: 2019/5/28 下午3:45
 * @mofified By:
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> selectRoleListByUserId(String userId) {
        List<Role> roleList = roleMapper.selectRoleListByUserId(userId);
        return roleList;
    }
}
