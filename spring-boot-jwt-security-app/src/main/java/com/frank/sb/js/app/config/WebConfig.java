package com.frank.sb.js.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 应用转发配置
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
        registry.addViewController("/login/page").setViewName("admin/login/login");

        // logout/page映射到logout_welcome.ftl上
        registry.addViewController("/logout/page").setViewName("admin/login/login");

        // logout映射为logout页面
        registry.addViewController("/logout").setViewName("logout");
    }
}
