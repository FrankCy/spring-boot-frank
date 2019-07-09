package com.frank.oauth.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-oauth2.0
 * @package: com.frank.oauth.client.config、
 * @email: cy880708@163.com
 * @date: 2019/5/30 上午10:26
 * @mofified By:
 */
public class ClassPathTldsLoader {

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    /**
     * 指定路径
     */
    private static final String SECURITY_TLD = "/META-INF/security.tld";

    final private List<String> classPathTlds;

    public ClassPathTldsLoader(String... classPathTlds) {
        super();
        if(classPathTlds == null || classPathTlds.length <= 0){
            this.classPathTlds = Arrays.asList(SECURITY_TLD);
        }else{
            this.classPathTlds = Arrays.asList(classPathTlds);
        }
    }

    @PostConstruct
    public void loadClassPathTlds() {
        freeMarkerConfigurer.getTaglibFactory().setClasspathTlds(classPathTlds);
    }

}
