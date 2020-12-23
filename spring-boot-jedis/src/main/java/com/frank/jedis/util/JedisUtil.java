package com.frank.jedis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

/**
 *
 *
 * @author cy
 * @version JedisUtil.java, v 0.1 2020年12月23日 2:08 下午 cy Exp $
 */
@Component
public class JedisUtil {


    @Autowired
    private JedisPool jedisPool;

    /**
     * 写入缓存
     * @param key
     * @param value
     * @return
     */
    public boolean set (final String key,String  value){
        boolean result = false;
        try {
            jedisPool.getResource().set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("set cache error");
        }
        return result ;
    }

    /**
     * 读取缓存
     * @param key
     * @return
     */
    public String get(final String key) {
        String result =null;
        result = jedisPool.getResource().get(key);
        return result;
    }


    /**
     * 删除key对应的value
     * @param key
     */
    public void del(final String key) {
        if(key!=null&&key.length()>=1&&!key.equals("")&&jedisPool.getResource().exists(key)){
            jedisPool.getResource().del(key);
        }
    }

    /**
     * 判断缓存中是否有key对应的value
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return jedisPool.getResource().exists(key);
    }

    /**
     * 写入缓存（规定缓存时间）
     * @param key
     * @param value
     * @param expireSecond
     * @return
     */
    public boolean set(final String key,String value,Long expireSecond) {
        boolean result = false;
        try {
            // NX代表不存在才set,EX代表秒,NX代表毫秒
            jedisPool.getResource().set(key, value, "NX", "EX", expireSecond);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("set cache error on time");
        }
        return result;
    }

    /**
     * <p>
     * 通过key向list头部添加字符串
     * </p>
     *
     * @param key
     * @param strs
     *            可以使一个string 也可以使string数组
     * @return 返回list的value个数
     */
    public Long lpush(String key, String... strs) {
        Long res = null;
        res = jedisPool.getResource().lpush(key, strs);
        return res;
    }

}
