package com.frank.sb.transactional.service;

import com.frank.sb.transactional.entity.po.Dept;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-frank
 * @package: com.frank.sb.transactional.service、
 * @email: cy880708@163.com
 * @date: 2019/7/23 下午4:19
 * @mofified By:
 */
public interface DeptService {

    /**
     * 新增部门信息
     * @param dept
     * @return
     */
    int insertSelective(Dept dept);
}
