package com.frank.sb.js.app.service.impl;

import com.frank.sb.js.app.dao.mapper.AuthMapper;
import com.frank.sb.js.app.entity.Role;
import com.frank.sb.js.app.entity.UserDetail;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-frank
 * @package: com.frank.sb.js.app.service.impl、
 * @email: cy880708@163.com
 * @date: 2019/7/8 下午6:39
 * @mofified By:
 */
@Component(value="CustomUserDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    private final AuthMapper authMapper;

    public CustomUserDetailsServiceImpl(AuthMapper authMapper) {
        this.authMapper = authMapper;
    }

    @Override
    public UserDetail loadUserByUsername(String name) throws UsernameNotFoundException {
        UserDetail userDetail = authMapper.findByUsername(name);
        if (userDetail == null) {
            throw new UsernameNotFoundException(String.format("No userDetail found with username '%s'.", name));
        }
        Role role = authMapper.findRoleByUserId(userDetail.getId());
        userDetail.setRole(role);
        return userDetail;
    }
}
