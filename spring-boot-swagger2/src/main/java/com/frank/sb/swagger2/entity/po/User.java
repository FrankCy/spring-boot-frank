package com.frank.sb.swagger2.entity.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-frank
 * @package: com.frank.sb.swagger2.entity、
 * @email: cy880708@163.com
 * @date: 2019/7/1 下午2:46
 * @mofified By:
 */
@ApiModel("用户实体")
public class User {

    /**
     * 主键
     */
    @ApiModelProperty("用户主键")
    private String id;

    /**
     * 名称
     */
    @ApiModelProperty("用户名")
    private String name;

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

}
