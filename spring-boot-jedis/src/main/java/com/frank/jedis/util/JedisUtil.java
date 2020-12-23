package com.frank.jedis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

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
    public boolean set (final String key,String value){
        Jedis jedis = getJedis();
        boolean result = false;
        try {
            jedis.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("set cache error");
        } finally {
            jedis.close();
        }
        return result ;
    }

    /**
     * 写入缓存（时效）
     * @param key
     * @param value
     * @return
     */
    public boolean set (final String key,String value, Integer time){
        boolean result = false;
        Jedis jedis = getJedis();
        try {
            SetParams setParams = SetParams.setParams().ex(time);
            jedis.set(key, value, setParams);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("set cache error");
        } finally {
            jedis.close();
        }
        return result ;
    }

    /**
     * 读取缓存
     * @param key
     * @return
     */
    public String get(final String key) {
        String result = null;
        Jedis jedis = getJedis();
        try {
            result = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("get cache error");
        } finally {
            jedis.close();
        }
        return result;
    }


    /**
     * 删除key对应的value
     * @param key
     */
    public void del(final String key) {
        Jedis jedis = getJedis();
        try {
            if(key!=null&&key.length()>=1&&!key.equals("")&&jedis.exists(key)){
                jedis.del(key);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("del cache error");
        } finally {
            jedis.close();
        }
    }

    /**
     * 判断缓存中是否有key对应的value
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        boolean result = false;
        Jedis jedis = getJedis();
        try {
            result = jedis.exists(key);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("exists cache error");
        } finally {
            jedis.close();
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
        Jedis jedis = getJedis();
        try {
            res = jedis.lpush(key, strs);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("lpush cache error");
        } finally {
            jedis.close();
        }
        return res;
    }

    /**
     * 增加increment
     * @param key
     * @param increment
     * @return
     */
    public Long incr(String key, Long increment) {
        Long incrResult = null;
        Jedis jedis = getJedis();
        try {
            incrResult = jedis.incrBy(key, 1L);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("incr cache error");
        } finally {
            jedis.close();
        }
        return incrResult;
    }
    
    public Jedis getJedis() {
        return jedisPool.getResource();
    }

}
