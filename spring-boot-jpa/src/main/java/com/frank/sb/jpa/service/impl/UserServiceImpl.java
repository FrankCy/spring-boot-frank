package com.frank.sb.jpa.service.impl;

import com.frank.sb.jpa.entity.User;
import com.frank.sb.jpa.repository.UserRepository;
import com.frank.sb.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @ProjectName: spring-boot-frank
 * @Package: com.frank.sb.jpa.service.impl
 * @ClassName: UserServiceImpl
 * @Author: cy
 * @Description: ${description}
 * @Date: 2020-04-21 18:24
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User insertUser(String var) {
        User sUser = new User();
        sUser.setId(1);
        sUser.setEmail("cy880708@163.com");
        sUser.setLastName("Frank");
        User user = userRepository.save(sUser);
        return user;
    }

    @Override
    public Optional<User> selectUser(String var) {
        User user = new User();
        user.setId(1);
        Example<User> example = Example.of(user);
        Optional<User> one = userRepository.findOne(example);
        return one;
    }
}
