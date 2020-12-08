package com.frank.socket.server.service;

import com.frank.socket.server.message.PushMessage;

/**
 *
 *
 * @author cy
 * @version SocketIOService.java, v 0.1 2020年12月07日 4:01 下午 cy Exp $
 */
public interface SocketIOService {

    /**
     * 推送的事件
     */
    public static final String PUSH_EVENT = "push_event";

    /**
     * 启动服务
     * @throws Exception
     */
    void start() throws Exception;

    /**
     * 停止服务
     */
    void stop();

    /**
     * 推送信息
     * @param pushMessage
     */
    void pushMessageToUser(PushMessage pushMessage);

}
