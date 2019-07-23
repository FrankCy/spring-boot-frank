package com.frank.sb.transactional.service.impl;

import com.frank.sb.transactional.dao.mapper.DeptMapper;
import com.frank.sb.transactional.entity.po.Dept;
import com.frank.sb.transactional.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-frank
 * @package: com.frank.sb.transactional.service.impl、
 * @email: cy880708@163.com
 * @date: 2019/7/23 下午4:19
 * @mofified By:
 */
@Service("deptService")
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    @Transactional
    public int insertSelective(Dept dept) {
        return deptMapper.insertSelective(dept);
    }
}
