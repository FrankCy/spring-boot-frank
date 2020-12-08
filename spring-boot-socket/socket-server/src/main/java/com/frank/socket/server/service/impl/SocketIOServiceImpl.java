package com.frank.socket.server.service.impl;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.frank.socket.server.message.PushMessage;
import com.frank.socket.server.service.SocketIOService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 *
 * @author cy
 * @version SocketIOServiceImpl.java, v 0.1 2020年12月07日 4:03 下午 cy Exp $
 */
@Slf4j
@Service(value = "socketIOService")
public class SocketIOServiceImpl implements SocketIOService {

    /**
     * 用来存已连接的客户端
     */
    private static Map<String, SocketIOClient> clientMap = new ConcurrentHashMap<>();

    @Autowired
    private SocketIOServer socketIOServer;

    /**
     * Spring IoC容器创建之后，在加载SocketIOServiceImpl Bean之后启动
     * @throws Exception
     */
    @PostConstruct
    private void autoStartup() throws Exception {
        start();
    }

    /**
     * Spring IoC容器在销毁SocketIOServiceImpl Bean之前关闭,避免重启项目服务端口占用问题
     * @throws Exception
     */
    @PreDestroy
    private void autoStop() throws Exception  {
        stop();
    }

    @Override
    public void start() {
        // 监听客户端连接
        socketIOServer.addConnectListener(client -> {
            String loginUserNum = getParamsByClient(client);
            if (loginUserNum != null) {
                clientMap.put(loginUserNum, client);
            }
        });

        // 监听客户端断开连接
        socketIOServer.addDisconnectListener(client -> {
            String loginUserNum = getParamsByClient(client);
            if (loginUserNum != null) {
                clientMap.remove(loginUserNum);
                client.disconnect();
            }
        });

        // 处理自定义的事件，与连接监听类似
        socketIOServer.addEventListener(PUSH_EVENT, PushMessage.class, (client, data, ackSender) -> {
            // TODO do something
        });
        socketIOServer.start();
    }

    @Override
    public void stop() {
        if (socketIOServer != null) {
            socketIOServer.stop();
            socketIOServer = null;
        }
    }

    @Override
    public void pushMessageToUser(PushMessage pushMessage) {
        log.info("pushMessage content  ->  " + pushMessage.getContent());
        log.info("pushMessage loginUserName ->  " + pushMessage.getLoginUserNum());
        Integer loginUserNum = pushMessage.getLoginUserNum();
        String loginUser = "";
        if(loginUserNum == null) {
            loginUser = "";
            return;
        } else {
            loginUser = String.valueOf(loginUserNum);
        }
        if (StringUtils.isNotBlank(loginUser)) {
            SocketIOClient client = clientMap.get(loginUserNum);
            if (client != null) {
                client.sendEvent(PUSH_EVENT, pushMessage);
            }
        }
    }

    /**
     * 此方法为获取client连接中的参数，可根据需求更改
     * @param client
     * @return
     */
    private String getParamsByClient(SocketIOClient client) {
        // 从请求的连接中拿出参数（这里的loginUserNum必须是唯一标识）
        Map<String, List<String>> params = client.getHandshakeData().getUrlParams();
        List<String> list = params.get("loginUserNum");
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}