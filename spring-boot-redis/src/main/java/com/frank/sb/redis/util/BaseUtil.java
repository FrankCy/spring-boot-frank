package com.frank.sb.redis.util;

import java.util.UUID;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-redis
 * @package: com.sbr.test.util、
 * @email: cy880708@163.com
 * @date: 2019/1/4 下午2:06
 * @mofified By:
 */
public class BaseUtil {

    /**
     * @description：获取一个随机生成UUID
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/1/4 下午2:07
     * @mofified By:
     */
    public static String getUUID() {
        String uuidStr = UUID.randomUUID().toString();
        uuidStr = uuidStr.replace("-", "");
        return uuidStr;
    }

    public static void main(String[] args) {
        System.out.println(getUUID());
    }
}
