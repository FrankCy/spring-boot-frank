package com.frank.jedis.service;

/**
 *
 *
 * @author cy
 * @version JedisService.java, v 0.1 2020年12月23日 1:59 下午 cy Exp $
 */
public interface JedisService {

    void set(String key, String val);

    String get(String key);
}
