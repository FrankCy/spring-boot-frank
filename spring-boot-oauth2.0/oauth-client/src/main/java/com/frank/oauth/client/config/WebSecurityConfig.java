package com.frank.oauth.client.config;

import com.alibaba.fastjson.JSON;
import com.frank.oauth.common.util.AjaxResponseBody;
import com.frank.oauth.server.impl.UserDetailsServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;

/**
 * @version 1.0
 * @description：
 * @EnableGlobalMethodSecurity(prePostEnabled = true) —— 开启基于方法的声明式权限控制
 * 通过继承 WebSecurityConfigurerAdapter 获得默认安全功能。
 * @author: Yang.Chang
 * @project: spring-boot-oauth2.0
 * @package: com.frank.oauth.client.config、
 * @email: cy880708@163.com
 * @date: 2019/5/27 下午3:04
 * @mofified By:
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Log logger = LogFactory.getLog(WebSecurityConfig.class);

    @Value("${system.user.password.secret}")
    private String secret;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    /**
     * 配置用户账号和密码，通过数据库查找
     * @return
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        logger.info(" - - - - - - - - - - [ Begin ] 配置用户账号和密码，角色查询 - - - - - - - - - - ");
        // 密码编辑器
        PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder(secret);
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        // 设置密码加密方式
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        logger.info(" - - - - - - - - - - [ end ] 配置用户账号和密码，角色查询 - - - - - - - - - - ");
        return authenticationProvider;
    }

    /**
     * 加载 ClassPathTldsLoader
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(ClassPathTldsLoader.class)
    public ClassPathTldsLoader classPathTldsLoader(){
        return new ClassPathTldsLoader();
    }

    /**
     * 让登录页指向对应的请求路径和启用"记住我（Remember Me）"功能
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info(" - - - - - - - - - - [ begin ] 初始化限制请求  - - - - - - - - - - ");
        // 限定签名后的权限
        http.
                authorizeRequests()
                // 设置静态的资源允许所有访问
                .antMatchers("/css/**","/js/**", "/font/**").permitAll()
                .antMatchers("/admin/**", "/user/**").hasAnyAuthority("ADMIN", "SYSTEM")
                .antMatchers("/login/**").hasRole("OTHER")
                // 其他所有资源都需要登陆后才能访问
                .anyRequest().authenticated()
                // 设置默认登陆页面/login/page
                .and().formLogin().loginPage("/login/page")
                // 强制指定登陆成功后跳转的路劲
                .successHandler(new ForwardAuthenticationSuccessHandler("/admin/welcome"))
//                .failureUrl("/loginStatus?status=false")
                .permitAll()
                // 设置缓存，默认2周有效
                .and().rememberMe().tokenValiditySeconds(1209600).key("user_key")
                // 设置登出的路径和登出成功后访问的路径
                .and().logout().logoutUrl("/logout/page").logoutSuccessUrl("/welcome").permitAll();
        logger.info(" - - - - - - - - - - [ end ] 初始化限制请求  - - - - - - - - - - ");

        //403
        http.exceptionHandling().accessDeniedHandler((httpServletRequest, httpServletResponse, e) -> {
            AjaxResponseBody responseBody = new AjaxResponseBody();
            responseBody.setStatus("403");
            responseBody.setMsg("您没有权限访问此功能!");
            httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
            httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD");

            httpServletResponse.getWriter().write(JSON.toJSONString(responseBody));
        });

        //拦截
//        http.addFilterBefore(jwtAjaxFilter, UsernamePasswordAuthenticationFilter.class);
        // 禁用缓存
        http.headers().cacheControl();
    }

}
