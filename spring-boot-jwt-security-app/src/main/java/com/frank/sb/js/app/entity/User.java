package com.frank.sb.js.app.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;

import javax.validation.constraints.Size;

@Builder
public class User {

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true)
    @Size(min=6, max=20)
    private String name;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = true)
    @Size(min=8, max=20)
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}