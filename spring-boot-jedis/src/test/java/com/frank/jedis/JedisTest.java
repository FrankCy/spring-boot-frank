package com.frank.jedis;

import com.frank.jedis.util.JedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 *
 * @author cy
 * @version JedisTest.java, v 0.1 2020年12月23日 2:32 下午 cy Exp $
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JedisStartApplication.class)
public class JedisTest {

    @Autowired
    private JedisUtil jedisUtil;

    @Before
    public void before() throws Exception{
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void concurrentTesting() throws Exception {
        // 初始化最大值
        jedisUtil.set("max", "3");
        for(int i=0; i<10; i++) {
            log.info(concurrentIo("abc"));
        }
    }

    public String concurrentIo(String param) {
        String maxString = jedisUtil.get("max");
        int max = Integer.parseInt(maxString);
        if(jedisUtil.exists(param)) {
            Long countNew =  jedisUtil.incr(param, 1L);
            log.info("+1 之后等于 {}" , countNew);
            if(countNew > max) {
                return "----------------- 超过最大限制 -----------------";
            }
            return "累计成功";
        } else {
            jedisUtil.set(param, String.valueOf(1L), 5);
            return "首次请求，添加个有效参数5S";
        }
    }
}