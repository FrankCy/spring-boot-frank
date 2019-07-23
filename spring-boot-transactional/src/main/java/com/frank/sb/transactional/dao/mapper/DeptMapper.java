package com.frank.sb.transactional.dao.mapper;

import com.frank.sb.transactional.entity.po.Dept;

public interface DeptMapper {
    int deleteByPrimaryKey(String did);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(String did);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}