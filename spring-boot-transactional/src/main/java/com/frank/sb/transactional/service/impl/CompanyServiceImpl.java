package com.frank.sb.transactional.service.impl;

import com.frank.sb.transactional.dao.mapper.CompanyMapper;
import com.frank.sb.transactional.entity.po.Company;
import com.frank.sb.transactional.service.CompanyService;
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
 * @date: 2019/7/23 下午4:18
 * @mofified By:
 */
@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    @Transactional
    public int insertSelective(Company company) {
        System.out.println(1/0);
        return companyMapper.insertSelective(company);
    }
}
