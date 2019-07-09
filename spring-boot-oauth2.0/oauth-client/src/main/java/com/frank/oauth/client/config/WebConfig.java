package com.frank.oauth.client.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-oauth2.0
 * @package: com.frank.oauth.client.config、
 * @email: cy880708@163.com
 * @date: 2019/5/28 下午6:10
 * @mofified By:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 增加映射
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // login/page映射到login.ftl上
        registry.addViewController("/login/page").setViewName("login/login");

        // logout/page映射到logout_welcome.ftl上
        registry.addViewController("/logout/page").setViewName("logout_welcome");

        // logout映射为logout页面
        registry.addViewController("/logout").setViewName("logout");
    }
}
