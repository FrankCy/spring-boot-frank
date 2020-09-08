package com.frank.boot.pay.starter.strategy;

/**
 *
 *
 * @author cy
 * @version BankPayStrategy.java, v 0.1 2020年09月07日 22:05 cy Exp $
 */
public class BankPayStrategy implements PayStrategy {
    @Override
    public void doPay() {
        System.out.println("银行支付通道");
    }
}
