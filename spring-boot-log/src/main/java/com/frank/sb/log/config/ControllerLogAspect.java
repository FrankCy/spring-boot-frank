package com.frank.sb.log.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 *
 * @author cy
 * @version ControllerLogAspect.java, v 0.1 2020年11月16日 14:20 cy Exp $
 */
@Aspect
@Order(5)
@Component
@Slf4j
public class ControllerLogAspect {

    /**
     * 拦截的请求方法
     */
    private static String METHOD_LOG = "POST";

    /**
     * 是否记录日志
     */
    private static boolean CHECK_METHOD_FLAG = false;

    /**
     * 请求参数
     */
    private static String REQUEST_PARAMS;

    /**
     * 请求地址
     */
    private static String REQUEST_URL;


    @Pointcut("execution(public * com.frank.sb.log.controller..*.*(..))")
    public void controllerLog() {
    }

    @Before("controllerLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 只记录post方法
        if(METHOD_LOG.equals(request.getMethod())){
            CHECK_METHOD_FLAG = true;
            // 记录下请求内容
            log.info("请求URL : " + request.getRequestURL());
            log.info("请求IP : " + request.getRemoteAddr());
            log.info("请求方法 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
            ControllerLogAspect.REQUEST_URL = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();

            // 获取参数, 只取自定义的参数, 自带的HttpServletRequest, HttpServletResponse不管
            if (joinPoint.getArgs().length > 0) {
                for (Object o : joinPoint.getArgs()) {
                    if (o instanceof HttpServletRequest || o instanceof HttpServletResponse) {
                        continue;
                    }
                    log.info("请求参数 : " + JSON.toJSONString(o));
                    ControllerLogAspect.REQUEST_PARAMS = JSON.toJSONString(o);
                }
            }
        }
    }

    @AfterReturning(returning = "ret", pointcut = "controllerLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // ret响应参数，根据
        log.info(ret.toString());
    }

}