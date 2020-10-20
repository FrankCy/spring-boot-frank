package com.frank.mybatisplus.service.impl;

import com.frank.mybatisplus.entity.Role;
import com.frank.mybatisplus.mapper.RoleMapper;
import com.frank.mybatisplus.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
