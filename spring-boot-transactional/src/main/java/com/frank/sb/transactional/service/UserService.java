package com.frank.sb.transactional.service;

import com.frank.sb.transactional.entity.po.User;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-frank
 * @package: com.frank.sb.transactional.service、
 * @email: cy880708@163.com
 * @date: 2019/7/23 下午4:09
 * @mofified By:
 */
public interface UserService {

    /**
     * 新增用户信息
     * @param user
     * @return
     */
    int insertSelective(User user);

}
