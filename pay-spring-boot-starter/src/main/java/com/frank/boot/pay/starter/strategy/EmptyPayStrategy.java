package com.frank.boot.pay.starter.strategy;

/**
 *
 * 空策略，避免获取策略时传递参数有问题，导致无法获取策略
 *
 * @author cy
 * @version EmptyPayStrategy.java, v 0.1 2020年09月07日 22:27 cy Exp $
 */
public class EmptyPayStrategy implements PayStrategy {
    @Override
    public void doPay() {
        System.out.println("参数有问题，无法使用的支付通道");
    }
}
