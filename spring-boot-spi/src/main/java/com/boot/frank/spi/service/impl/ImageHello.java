package com.boot.frank.spi.service.impl;

import com.boot.frank.spi.service.HelloSpi;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author cy
 * @version HelloSpi.java, v 0.1 2020年09月07日 15:05 cy Exp $
 */
@Service("imageHello")
public class ImageHello implements HelloSpi {
    @Override
    public void sayHello() {
        System.out.println("ImageHello");
    }
}
