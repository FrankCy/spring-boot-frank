package com.frank.mybatisplus.service.impl;

import com.frank.mybatisplus.entity.Login;
import com.frank.mybatisplus.mapper.LoginMapper;
import com.frank.mybatisplus.service.ILoginService;
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
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements ILoginService {

}
