package com.frank.socket.vue.server.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *
 *
 * @author cy
 * @version WebSocket.java, v 0.1 2020年12月08日 1:52 下午 cy Exp $
 */
@Slf4j
@Component
/**
 * 此注解相当于设置访问URL
 */
@ServerEndpoint("/websocket/{shopId}")
public class WebSocket {

    private Session session;

    private static CopyOnWriteArraySet<WebSocket> webSockets =new CopyOnWriteArraySet<>();

    private static Map<String,Session> sessionPool = new HashMap<String,Session>();

    @OnOpen
    public void onOpen(Session session, @PathParam(value="shopId")String shopId) {
        log.info("shopId -> {}" , shopId);
        this.session = session;
        webSockets.add(this);
        sessionPool.put(shopId, session);
        System.out.println("【websocket消息】有新的连接，总数为:"+webSockets.size());
    }

    @OnClose
    public void onClose() {
        webSockets.remove(this);
        System.out.println("【websocket消息】连接断开，总数为:"+webSockets.size());
    }

    public void onClose(String id) {
        webSockets.remove(id);
        System.out.println("【websocket"+ id +"消息】连接断开，总数为:"+webSockets.size());
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("【websocket消息】收到客户端消息:"+message);
    }

    /**
     * 此为广播消息
     * @param message
     */
    public void sendAllMessage(String message) {
        for(WebSocket webSocket : webSockets) {
            System.out.println("【websocket消息】广播消息:"+message);
            try {
                webSocket.session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 此为单点消息 (发送文本)
     * @param shopId
     * @param message
     */
    public void sendTextMessage(String shopId, String message) {
        log.info("sendTextMessage -> shopId {}", shopId);
        log.info("sendTextMessage -> message {}", message);
        Session session = sessionPool.get(shopId);
        if (session != null) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 此为单点消息 (发送对象)
     * @param shopId
     * @param message
     */
    public void sendObjMessage(String shopId, Object message) {
        log.info("sendObjMessage -> shopId {}", shopId);
        log.info("sendObjMessage -> message {}", message);
        Session session = sessionPool.get(shopId);
        if (session != null) {
            try {
                session.getAsyncRemote().sendObject(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}