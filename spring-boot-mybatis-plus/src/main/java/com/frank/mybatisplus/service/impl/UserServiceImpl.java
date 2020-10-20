package com.frank.mybatisplus.service.impl;

import com.frank.mybatisplus.entity.User;
import com.frank.mybatisplus.mapper.UserMapper;
import com.frank.mybatisplus.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Cyoung
 * @since 2020-10-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
