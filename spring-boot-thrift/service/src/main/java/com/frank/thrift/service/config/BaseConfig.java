package com.frank.thrift.service.config;

import com.frank.thrift.service.server.ThriftServer2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author cy
 * @version BaseConfig.java, v 0.1 2020年12月04日 10:32 上午 cy Exp $
 */
@Slf4j
@Component
public class BaseConfig {

    /**
     * 向Spring注册一个Bean对象
     * initMethod = "start"  表示会执行名为start的方法
     * start方法执行之后，就会阻塞接受客户端的请求
     *
     * @return
     */
    @Bean(initMethod = "start")
    public ThriftServer2 init() {
        log.info("初始化启动.....begin");
        ThriftServer2 thriftServer = new ThriftServer2();
        log.info("初始化启动.....end");
        return thriftServer;
    }

}
