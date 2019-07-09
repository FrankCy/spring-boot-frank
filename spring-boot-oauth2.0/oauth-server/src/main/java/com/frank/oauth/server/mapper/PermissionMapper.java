package com.frank.oauth.server.mapper;

import com.frank.oauth.entity.po.Permission;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    /**
     * 根据userId，查询所有相关权限
     * @param id
     * @return
     */
    List<Permission> selectByUserId(String id);
}