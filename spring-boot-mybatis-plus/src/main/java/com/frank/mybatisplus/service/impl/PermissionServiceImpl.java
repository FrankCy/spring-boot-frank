package com.frank.mybatisplus.service.impl;

import com.frank.mybatisplus.entity.Permission;
import com.frank.mybatisplus.mapper.PermissionMapper;
import com.frank.mybatisplus.service.IPermissionService;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
