package com.frank.mybatisplus.service.impl;

import com.frank.mybatisplus.entity.Group;
import com.frank.mybatisplus.mapper.GroupMapper;
import com.frank.mybatisplus.service.IGroupService;
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
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements IGroupService {

}
