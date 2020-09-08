package com.frank.boot.pay.starter.strategy;

/**
 *
 *
 * @author cy
 * @version WechatPayStrategy.java, v 0.1 2020年09月07日 22:05 cy Exp $
 */
public class WechatPayStrategy implements PayStrategy {
    @Override
    public void doPay() {
        System.out.println("微信支付通道");
    }
}
