package com.frank.oauth.common.util;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: spring-boot-oauth2.0
 * @package: com.frank.oauth.common.util、
 * @email: cy880708@163.com
 * @date: 2019/5/29 上午10:47
 * @mofified By:
 */
public class AjaxResponseBody {

    private String Status;

    private String Msg;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }
}
