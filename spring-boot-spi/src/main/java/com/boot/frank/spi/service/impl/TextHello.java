package com.boot.frank.spi.service.impl;

import com.boot.frank.spi.service.HelloSpi;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author cy
 * @version TextHello.java, v 0.1 2020年09月07日 15:06 cy Exp $
 */
@Service("textHello")
public class TextHello implements HelloSpi {

    private TextHello(String source) {
        if(!"text".equals(source.trim())) {
            return;
        }
    }

    @Override
    public void sayHello() {
        System.out.println("TextHello");
    }
}
