package com.frank.quartz.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * 接口返回结果
 * @author zhangliang
 * @version $Id: ApiResult.java, v 0.1 2020年05月11日 17:55 zhangliang Exp $
 */
@Data
@ApiModel(value = "接口返回结果")
public class ApiResult<T> implements Serializable {

    private static final long serialVersionUID = -2953545018812382877L;

    /**
     * 返回码，200 正常
     */
    @ApiModelProperty(value = "返回码，200 正常", name = "status")
    private int status = 200;

    /**
     * 返回信息
     */
    @ApiModelProperty(value = "返回信息", name = "msg")
    private String msg = "成功";

    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据对象", name = "data")
    private T result;

    /**
     * 附加数据
     */
    @ApiModelProperty(value = "附加数据", name = "extraData")
    private Map<String, Object> extraData;

    /**
     * 系统当前时间
     */
    @ApiModelProperty(value = "服务器系统时间，时间戳(精确到毫秒)", name = "timestamp")
    private Long timestamp = System.currentTimeMillis();

    /**
     * 获取成功状态结果
     *
     * @return
     */
    public static ApiResult success() {
        return success(null, null);
    }

    /**
     * 获取成功状态结果
     *
     * @param data 返回数据
     * @return
     */
    public static ApiResult success(Object data) {
        return success(data, null);
    }

    /**
     * 获取成功状态结果
     *
     * @param result 返回数据
     * @param extraData 附加数据
     * @return
     */
    public static ApiResult success(Object result, Map<String, Object> extraData) {
        ApiResult apiResult = new ApiResult();
        apiResult.setStatus(ResponseCode.SUCCESS.getCode());
        apiResult.setMsg(ResponseCode.SUCCESS.getMsg());
        apiResult.setResult(result);
        apiResult.setExtraData(extraData);
        return apiResult;
    }

    /**
     * 获取失败状态结果
     *
     * @return
     */
    public static ApiResult failure() {
        return failure(ResponseCode.FAIL.getCode(), ResponseCode.FAIL.getMsg(), null);
    }

    /**
     * 获取失败状态结果
     *
     * @param msg (自定义)失败消息
     * @return
     */
    public static ApiResult failure(String msg) {
        return failure(ResponseCode.FAIL.getCode(), msg, null);
    }

    /**
     * 获取失败状态结果
     *
     * @param responseCode 返回状态码
     * @return
     */
    public static ApiResult failure(ResponseCode responseCode) {
        return failure(responseCode.getCode(), responseCode.getMsg(), null);
    }

    /**
     * 获取失败状态结果
     *
     * @param responseCode 返回状态码
     * @param data         返回数据
     * @return
     */
    public static ApiResult failure(ResponseCode responseCode, Object data) {
        return failure(responseCode.getCode(), responseCode.getMsg(), data);
    }

    /**
     * 获取失败返回结果
     *
     * @param status 错误码
     * @param msg  错误信息
     * @param result 返回结果
     * @return
     */
    public static ApiResult failure(int status, String msg, Object result) {
        ApiResult apiResult = new ApiResult();
        apiResult.setStatus(status);
        apiResult.setMsg(msg);
        apiResult.setResult(result);
        return apiResult;
    }

    public ApiResult setStatus(int status) {
        this.status = status;
        return this;
    }

}
