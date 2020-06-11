package com.frank.quartz.util;

/**
 * @description：
 * @version 1.0
 * @author: Yang.Chang
 * @email: cy880708@163.com
 * @date: 2019/5/31 下午6:14
 * @mofified By:
 */
public enum ResultCode {

    /**
     * 成功
     */
    SUCCESS("200"),

    /**
     * 失败
     */
    FAIL("400"),

    /**
     * 服务器错误
     */
    INTERNAL_SERVER_ERROR("500"),

    UNAUTHORIZED("401","未认证（签名错误）"),

    NOT_FOUND("404","接口不存在"),
    /**
     * 无效果的Sgin
     */
    INVALID_SIGN("403", "参数签名无效");

    private String code;
    private String message;

    ResultCode(String code) {
        this.code = code;
    }

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }
}
