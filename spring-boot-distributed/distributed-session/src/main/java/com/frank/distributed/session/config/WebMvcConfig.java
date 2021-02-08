package com.frank.distributed.session.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * 启用拦截器
 *
 * @author cy
 * @version WebMvcConfig.java, v 0.1 2021年02月08日 3:16 下午 cy Exp $
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
        // 设置需要拦截的路径
        .addPathPatterns("/login/*")
        // 设置需要拦截的路径
        .addPathPatterns("/user/*")
        // 不拦截/user/login接口
        .excludePathPatterns("/user/login");
    }
}
