package com.frank.mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 *
 * @author cy
 * @version SmsLogEntity.java, v 0.1 2021年07月14日 5:26 下午 cy Exp $
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "sms_log")
public class SmsLogEntity {

    @Id
    private String id;

    /**
     * 云厂商
     */
    private String cloudVendors;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 发送内容
     */
    private String sendInfo;

    /**
     * 响应信息
     */
    private String resultMessage;

    /**
     * 请求平台所返回的信息
     */
    private String requestLog;

    /**
     * 状态
     * sendSuccess：发送至平台成功（未回调）
     * sendError：发送至平台错误
     * callback：回调结束
     */
    private String smsStatus;

    /**
     * 响应信息ID（调用发短信SDK，成功状态下的MessageId，用于校验回调信息是否一致，以此来更新数据）
     * none:代表没有发起请求，在请求AWS时发生错误（只有AWS会出现none）
     */
    private String messageId;

    /**
     * 回调的日志
     */
    private String callBackLog;

    /**
     * 回调写入的时间
     */
    private String callBackTime;

    /**
     * 创建时间
     */
    private String createdTime;

    /**
     * 最后修改时间
     */
    private String lastUpdateTime;

    /**
     * 区域
     */
    private String region;

    /**
     * 状态代码：2:成功下发，其他数字都未下发成功
     */
    private String callBackStatus;

    /**
     * 成功个数： DELIVRD
     */
    private Integer callBackResultSuccess;

    /**
     * 失败个数： UNDELIV
     */
    private Integer callBackResultError;

    /**
     * 实际运营商推送的时间
     */
    private String drtime;

    /**
     * 短信单价
     */
    private Double price;
    /**
     * 短信总价  callbacksize * price
     */
    private Double totalPrice;

    /**
     * 美元对人民币汇率 如：7.05
     */
    private String rate;

    /**
     * 计费条数
     */
    private String callBackSize;

    /**
     * 当前日期 例：2021-02-05
     */
    private String day;

    /**
     * 当前月份 例： 2021-02
     */
    private String month;

    /**
     * 当前年份 例： 2021
     */
    private String year;
    /**
     * 短信总数
     */
    private String total;

}
