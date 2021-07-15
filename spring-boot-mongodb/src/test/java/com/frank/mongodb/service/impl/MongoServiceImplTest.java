package com.frank.mongodb.service.impl;

import com.frank.mongodb.MongoApplication;
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
 * @version MongoServiceImplTest.java, v 0.1 2021年07月14日 6:00 下午 cy Exp $
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MongoApplication.class)
public class MongoServiceImplTest {
    @Autowired
    private MongoServiceImpl mongoService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void statisticsTariff() throws Exception {
        mongoService.statisticsTariff();
    }

}