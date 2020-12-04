package com.frank.thrift.client.config;

import com.frank.thrift.client.core.ThriftClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 *
 * @author cy
 * @version ThriftClientConfig.java, v 0.1 2020年12月04日 10:53 上午 cy Exp $
 */
@Configuration
public class ThriftClientConfig {
    /**
     * 服务端的地址
     */
    @Value("${server.thrift.host}")
    private String host;

    /**
     * 服务端的端口
     */
    @Value("${server.thrift.port}")
    private Integer port;

    /**
     * 初始化Bean的时候调用对象里面的init方法
     * @return
     */
    @Bean(initMethod = "init")

    /**
     * 每次请求实例化一个新的ThriftClient连接对象
     */
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public ThriftClient init() {
        ThriftClient thriftClient = new ThriftClient();
        thriftClient.setHost(host);
        thriftClient.setPort(port);
        return thriftClient;
    }
}

