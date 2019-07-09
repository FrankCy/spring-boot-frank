package com.frank.sb.js.app.domain.po;

import javax.persistence.Column;

public class User {

    /**
     * 用户名
     */
    @Column(name = "username", nullable = false, unique = true)
    private String userName;

    /**
     * 密码
     */
    @Column(name = "password", nullable = false)
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
