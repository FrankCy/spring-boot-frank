package com.frank.socket.vue.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 *
 *
 * @author cy
 * @version WebSocketConfig.java, v 0.1 2020年12月08日 1:52 下午 cy Exp $
 */
@Configuration
public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}