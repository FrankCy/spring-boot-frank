package com.frank.oauth.server.impl;

import com.frank.oauth.entity.po.Role;
import com.frank.oauth.entity.po.User;
import com.frank.oauth.server.service.RoleService;
import com.frank.oauth.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-oauth2.0
 * @package: com.frank.oauth.server.impl、
 * @email: cy880708@163.com
 * @date: 2019/5/28 下午3:24
 * @mofified By:
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    /**
     * 注入角色服务接口
     */
    @Autowired
    private RoleService roleService;

    /**
     * 注入用户服务接口
     */
    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        // 获取数据库用户信息
        User user = userService.selectByName(userName);

        if(user == null) {
            throw new RuntimeException("登陆失败，无法找到此用户！");
        }

        // 获取数据库角色信息
        List<Role> roleList = roleService.selectRoleListByUserId(user.getId());

        // 将信息转换为Detail（权限认证用）
        return changeToUser(user, roleList);
    }

    public UserDetails changeToUser(User user, List<Role> roleList) {
        // 权限列表
        List<GrantedAuthority> authorityList = new ArrayList<>();

        // 赋予查询到的角色
        for(Role role : roleList) {
            GrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
            authorityList.add(authority);
        }

        // 创建UserDetails对象，设置用户名、密码和权限
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorityList);

        return userDetails;
    }

}
