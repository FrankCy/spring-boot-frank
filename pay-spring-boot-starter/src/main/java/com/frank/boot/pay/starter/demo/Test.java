package com.frank.boot.pay.starter.demo;

import com.frank.boot.pay.starter.strategy.PayActivity;
import com.frank.boot.pay.starter.strategy.ZhiFuBaoPayStrategy;

/**
 *
 *
 * @author cy
 * @version Test.java, v 0.1 2020年09月08日 08:34 cy Exp $
 */
public class Test {
    public static void main(String[] args) {
        PayActivity payActivity = new PayActivity(new ZhiFuBaoPayStrategy());
        payActivity.executePayStrategy();
    }
}
