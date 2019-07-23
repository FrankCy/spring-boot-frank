package com.frank.sb.transactional.service;

import com.frank.sb.transactional.entity.po.Company;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-frank
 * @package: com.frank.sb.transactional.service、
 * @email: cy880708@163.com
 * @date: 2019/7/23 下午4:18
 * @mofified By:
 */
public interface CompanyService {

    /**
     * 新增用户信息
     * @param company
     * @return
     */
    int insertSelective(Company company);
}
