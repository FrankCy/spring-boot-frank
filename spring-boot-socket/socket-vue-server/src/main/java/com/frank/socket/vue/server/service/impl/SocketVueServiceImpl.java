package com.frank.socket.vue.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.frank.socket.vue.server.config.WebSocket;
import com.frank.socket.vue.server.service.SocketVueService;
import com.frank.socket.vue.server.vo.TestObj;
import com.frank.socket.vue.server.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        TestObj testObj = new TestObj();
        testObj.setId(1L);
        testObj.setName("张三");
        testObj.setMessage("Test Message");
        List<User> userList = new ArrayList<>();
        for(int i=0; i<10; i++) {
            Thread.sleep(1000);
            if(i > 5) {
                User user = new User();
                user.setId(i);
                user.setAge(i+100);
                user.setName("王"+i);
                user.setDescription("描述信息"+i);
                userList.add(user);
                testObj.setUserList(userList);
                webSocket.sendTextMessage(shipId, JSON.toJSONString(testObj));
            } else {
                webSocket.sendTextMessage(shipId, JSON.toJSONString(testObj));
            }
            if (i == 9) {
                webSocket.onClose();
            }
        }
        return null;
    }

}
