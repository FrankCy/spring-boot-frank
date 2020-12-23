package com.frank.nacos.dubbo.provider.service.impl;

import com.frank.nacos.dubbo.api.service.DubboDemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

/**
 *
 *
 * @author cy
 * @version DubboDemoService.java, v 0.1 2020年12月23日 11:22 上午 cy Exp $
 */
@Slf4j
@Service
public class DubboDemoServiceImpl implements DubboDemoService {

    @Override
    public String helloDubbo(String param) {
        log.info("DubboDemoServiceImpl helloDubbo 被调用，请求参数：{}", param);
        return "服务端也帅！";
    }

}
