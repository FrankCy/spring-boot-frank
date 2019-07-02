package com.frank.sb.swagger2.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-frank
 * @package: com.frank.sb.swagger2.entity.vo、
 * @email: cy880708@163.com
 * @date: 2019/7/2 下午5:50
 * @mofified By:
 */
@ApiModel("用户请求实体")
public class UserVO {

    @ApiModelProperty("用户主键")
    private String userId;

    @ApiModelProperty("用户名")
    private String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
