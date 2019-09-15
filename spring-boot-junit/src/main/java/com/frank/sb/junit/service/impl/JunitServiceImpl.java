package com.frank.sb.junit.service.impl;

import com.frank.sb.junit.service.JunitService;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-frank
 * @package: com.frank.sb.junit.service.impl、
 * @email: cy880708@163.com
 * @date: 2019/9/15 下午4:25
 * @mofified By:
 */
@Service
public class JunitServiceImpl implements JunitService {
    @Override
    public String junitTestServiceString(String reqParam) {
        System.out.println("sign in service impl ------");
        return "你好："+ reqParam;
    }
}
