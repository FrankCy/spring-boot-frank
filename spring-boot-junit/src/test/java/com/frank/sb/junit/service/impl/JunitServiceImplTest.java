package com.frank.sb.junit.service.impl;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-frank
 * @package: com.frank.sb.junit.service.impl、
 * @email: cy880708@163.com
 * @date: 2019/9/15 下午4:27
 * @mofified By:
 */
@SpringBootTest
public class JunitServiceImplTest {


    @Test
    public String junitTestServiceString(String reqParam) {
        return "你好："+ reqParam;
    }
}