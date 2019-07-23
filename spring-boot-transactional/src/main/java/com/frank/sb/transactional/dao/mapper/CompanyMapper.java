package com.frank.sb.transactional.dao.mapper;

import com.frank.sb.transactional.entity.po.Company;

public interface CompanyMapper {
    int deleteByPrimaryKey(String cId);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);
}