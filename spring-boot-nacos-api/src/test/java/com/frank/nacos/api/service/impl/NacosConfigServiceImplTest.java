package com.frank.nacos.api.service.impl;

import com.frank.nacos.api.NacosApiStartApplication;
import junit.framework.TestCase;
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
 * @version NacosConfigServiceImplTest.java, v 0.1 2021年02月25日 2:10 下午 cy Exp $
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = NacosApiStartApplication.class)
public class NacosConfigServiceImplTest extends TestCase {

    @Autowired
    private NacosConfigServiceImpl nacosConfigService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void findNacosConfig() throws Exception {
        nacosConfigService.findNacosConfig();
    }

}