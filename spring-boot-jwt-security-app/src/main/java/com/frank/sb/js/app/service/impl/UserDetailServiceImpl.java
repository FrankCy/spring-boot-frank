package com.frank.sb.js.app.service.impl;

import com.frank.sb.js.app.dao.mapper.UserMapper;
import com.frank.sb.js.app.domain.po.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    
    private UserMapper userMapper;

    /**
     * Instantiates a new User detail service.
     *
     * @param userMapper the user repository
     */
    public UserDetailServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User userDetails = userMapper.findByUsername(username);
        if(userDetails == null){
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(userDetails.getUserName(),userDetails.getPassword(), new ArrayList<>());
    }
}
