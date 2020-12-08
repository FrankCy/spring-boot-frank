package com.frank.socket.vue.server.service.impl;

import com.frank.socket.vue.server.config.WebSocket;
import com.frank.socket.vue.server.service.SocketVueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author cy
 * @version SocketVueServiceImpl.java, v 0.1 2020年12月08日 2:00 下午 cy Exp $
 */
@Service
public class SocketVueServiceImpl implements SocketVueService {

    @Autowired
    private WebSocket webSocket;

    @Override
    public Object xdxTest(String shipId) throws InterruptedException {
        for (int i = 0; i < 10; i++){
            Thread.sleep(1000);
            webSocket.sendTextMessage(shipId, "thread"+i);
        }
        return null;
    }
}
