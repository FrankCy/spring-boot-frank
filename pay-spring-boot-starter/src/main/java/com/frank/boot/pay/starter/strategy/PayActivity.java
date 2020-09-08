package com.frank.boot.pay.starter.strategy;

/**
 *
 *
 * @author cy
 * @version PayStrategyActivity.java, v 0.1 2020年09月07日 22:07 cy Exp $
 */
public class PayActivity {

    private PayStrategy payStrategy;

    public PayActivity(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    public void executePayStrategy() {
        payStrategy.doPay();
    }

}
