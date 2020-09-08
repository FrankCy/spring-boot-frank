package com.frank.boot.pay.starter.service.impl;

import com.frank.boot.pay.starter.service.PayService;
import com.frank.boot.pay.starter.strategy.PayActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author cy
 * @version PayServiceImpl.java, v 0.1 2020年09月08日 09:10 cy Exp $
 */
@Service("payServiceImpl")
public class PayServiceImpl implements PayService {

    @Autowired
    private PayActivity payActivity;

    @Override
    public void pay() {
        payActivity.executePayStrategy();
    }
}
