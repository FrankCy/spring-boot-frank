package com.frank.jedis;

import com.frank.jedis.util.JedisLock;
import com.frank.jedis.util.JedisUtil;
import com.ubirch.util.uuid.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private JedisLock jedisLock;

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

        //参数为线程个数
        final CountDownLatch cdl = new CountDownLatch(1000);

        ExecutorService executor = new ThreadPoolExecutor(100, 200, 0,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(500),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for(int i=0; i<1000; i++) {
            executor.execute(() -> {
                try {
                    log.info(concurrentIo("abc"));
                    cdl.countDown();
                    return;
                } catch (Exception e) {
                    System.out.println("wdnmd 我错了");
                    cdl.countDown();
                    e.printStackTrace();
                }
                System.out.println("我还执行不执行呢");
                // 此方法是CountDownLatch的线程数-1
                cdl.countDown();
            });
        }
        executor.shutdown();
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        //线程启动后调用countDownLatch方法
        try {
            // 需要捕获异常，当其中线程数为0时这里才会继续运行
            cdl.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("end = " + end);
        System.out.println("end - start = " + (end - start));
    }

    public String concurrentIo(String param) {
        String maxString = jedisUtil.get("max");
        int max = Integer.parseInt(maxString);
        String id = UUIDUtil.uuidStr();
        try {
            jedisLock.lock(id);
            if(jedisUtil.exists(param)) {
                Long countNew =  jedisUtil.incr(param, 1L);
                log.info("+1 之后等于 {}" , countNew);
                if(countNew > max) {
                    return "----------------- 超过最大限制 -----------------";
                }
                return "累计成功 -》" + countNew;
            } else {
                jedisUtil.set(param, String.valueOf(0L), 5);
                return "首次请求，添加个有效参数5S";
            }
        } finally {
            jedisLock.unlock(id);
        }

    }
}