package com.frank.socket.vue.server.config;

import com.alibaba.fastjson.JSON;
import com.frank.socket.vue.server.vo.TestObj;
import com.frank.socket.vue.server.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author cy
 * @version Task.java, v 0.1 2020年12月08日 3:26 下午 cy Exp $
 */
@Slf4j
@Component
public class Task {

    @Autowired
    private WebSocket webSocket;

    @Scheduled(fixedRate = 2000)
    public Object testTasks() throws InterruptedException {
        log.info("testTasks begin");
        TestObj testObj = new TestObj();
        testObj.setId(1L);
        testObj.setName("张三");
        testObj.setMessage("Test Message");
        List<User> userList = new ArrayList<>();
        for(int i=0; i<10; i++) {
            Thread.sleep(2000);
            if(i > 5) {
                User user = User.builder().id(i).age(i+100).name("王"+i).description("描述信息"+i).build();
                userList.add(user);
                testObj.setUserList(userList);
                webSocket.sendTextMessage("DPS007", JSON.toJSONString(testObj));
            } else {
                webSocket.sendTextMessage("DPS007", JSON.toJSONString(testObj));
            }
            if (i == 9) {
                webSocket.onClose("DPS007");
            }
        }
        return null;
    }

}
