package com.frank.sb.redis.bean;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-redis
 * @package: com.sbr.test.bean、
 * @email: cy880708@163.com
 * @date: 2019/1/4 下午2:00
 * @mofified By:
 */
public class User {

    private String id;

    private String name;

    private String tel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
