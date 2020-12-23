package com.frank.jedis.service.impl;

import com.frank.jedis.service.JedisService;
import com.frank.jedis.util.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author cy
 * @version JedisServiceImpl.java, v 0.1 2020年12月23日 2:00 下午 cy Exp $
 */
@Service
public class JedisServiceImpl implements JedisService {

    @Autowired
    private JedisUtil jedisUtil;

    @Override
    public void set(String key, String val) {
        jedisUtil.set(key, val);
    }

    @Override
    public String get(String key) {
        return jedisUtil.get(key);
    }
}
