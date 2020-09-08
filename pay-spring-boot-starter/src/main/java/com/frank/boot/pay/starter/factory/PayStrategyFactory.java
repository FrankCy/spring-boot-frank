package com.frank.boot.pay.starter.factory;

import com.frank.boot.pay.starter.strategy.BankPayStrategy;
import com.frank.boot.pay.starter.strategy.EmptyPayStrategy;
import com.frank.boot.pay.starter.strategy.PayStrategy;
import com.frank.boot.pay.starter.strategy.WechatPayStrategy;
import com.frank.boot.pay.starter.strategy.ZhiFuBaoPayStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author cy
 * @version PayStrategyFactory.java, v 0.1 2020年09月07日 22:24 cy Exp $
 */
public class PayStrategyFactory {

    private static Map<String, PayStrategy> PAY_STRATEGY_MAP = new HashMap<>();

    static {
        PAY_STRATEGY_MAP.put(PayKey.ZHI_FU_BAO, new ZhiFuBaoPayStrategy());
        PAY_STRATEGY_MAP.put(PayKey.WECHAT, new WechatPayStrategy());
        PAY_STRATEGY_MAP.put(PayKey.BANK, new BankPayStrategy());
    }

    /**
     * 通过构造私有构造函数，达到不会被new的效果
     */
    private PayStrategyFactory() {

    }

    private static final PayStrategy NON_PAY = new EmptyPayStrategy();

    public static PayStrategy getPayStrategy(String payKey) {
        PayStrategy payStrategy = PAY_STRATEGY_MAP.get(payKey);
        return payStrategy == null ? NON_PAY : payStrategy;
    }

    private interface PayKey {
        String ZHI_FU_BAO = "ZHIFUBAO";
        String WECHAT = "WECHAT";
        String BANK = "BANK";
    }



}
