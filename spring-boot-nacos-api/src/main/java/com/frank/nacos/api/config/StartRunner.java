package com.frank.nacos.api.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author cy
 * @version StartRunner.java, v 0.1 2020年12月30日 9:58 上午 cy Exp $
 */
@Slf4j
@Component
public class StartRunner implements ApplicationRunner {


    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("启动后执行");
    }
}