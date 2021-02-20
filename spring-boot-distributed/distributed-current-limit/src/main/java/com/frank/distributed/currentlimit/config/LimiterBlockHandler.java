package com.frank.distributed.currentlimit.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 自定义限流错误提示
 *
 * @author cy
 * @version LimiterBlockHandler.java, v 0.1 2021年02月20日 10:59 上午 cy Exp $
 */
@Slf4j
@Component
public class LimiterBlockHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        log.info("触发限流");
    }
}
