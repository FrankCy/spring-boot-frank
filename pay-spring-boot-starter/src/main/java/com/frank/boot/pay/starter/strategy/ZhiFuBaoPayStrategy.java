package com.frank.boot.pay.starter.strategy;

/**
 *
 *
 * @author cy
 * @version ZhiFuBaoPayStrategy.java, v 0.1 2020年09月07日 22:05 cy Exp $
 */
public class ZhiFuBaoPayStrategy implements PayStrategy{
    @Override
    public void doPay() {
        System.out.println("支付宝支付通道");
    }
}
