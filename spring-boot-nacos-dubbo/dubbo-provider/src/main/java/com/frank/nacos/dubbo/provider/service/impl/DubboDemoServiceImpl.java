package com.frank.nacos.dubbo.provider.service.impl;

import com.frank.nacos.dubbo.api.service.DubboDemoService;
import org.apache.dubbo.config.annotation.Service;

/**
 *
 *
 * @author cy
 * @version DubboDemoService.java, v 0.1 2020年12月23日 11:22 上午 cy Exp $
 */
@Service
public class DubboDemoServiceImpl implements DubboDemoService {

    @Override
    public String helloDubbo() {
        return "helloDubbo Provider";
    }

}
