package com.frank.oauth.server.service;

import com.frank.oauth.entity.po.UserRole;

import java.util.List;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-oauth2.0
 * @package: com.frank.oauth.server.service、
 * @email: cy880708@163.com
 * @date: 2019/5/28 下午3:25
 * @mofified By:
 */
public interface UserRoleService {

    /**
     * 根据id查询用户角色
     * @param id
     * @return
     */
    UserRole selectByName(String id);

}
