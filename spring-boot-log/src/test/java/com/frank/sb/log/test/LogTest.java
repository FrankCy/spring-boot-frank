package com.frank.sb.log.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-frank
 * @package: com.frank.sb.log.test、
 * @email: cy880708@163.com
 * @date: 2019/6/27 下午3:29
 * @mofified By:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class LogTest {

    private static final Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void test() {
        //
        logger.trace("trace 级别的日志");
        logger.debug("debug 级别的日志");
        logger.info("info 级别的日志");
        logger.warn("warn 级别的日志");
        logger.error("error 级别的日志");
    }

}
