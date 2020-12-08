package com.frank.socket.vue.server.controller;

import com.frank.socket.vue.server.service.SocketVueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author cy
 * @version SocketVueController.java, v 0.1 2020年12月08日 1:58 下午 cy Exp $
 */
@RestController
public class SocketVueController {

    @Autowired
    private SocketVueService socketVueService;

    /**
     *
     * @param shipId
     * @return
     */
    @GetMapping("/xdx/text")
    public Object xdxTest(String shipId) throws InterruptedException {
        return socketVueService.xdxTest(shipId);
    }

}


