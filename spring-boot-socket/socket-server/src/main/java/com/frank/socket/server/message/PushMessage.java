package com.frank.socket.server.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 *
 * @author cy
 * @version PushMessage.java, v 0.1 2020年12月07日 4:02 下午 cy Exp $
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PushMessage {

    /**
     * 登录用户编号
     */
    private Integer loginUserNum;

    /**
     * 推送内容
     */
    private String content;

}
