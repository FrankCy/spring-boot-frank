package com.frank.socket.vue.server.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 *
 *
 * @author cy
 * @version TestObj.java, v 0.1 2020年12月08日 3:03 下午 cy Exp $
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestObj implements Serializable {

    private static final long serialVersionUID = -2804136655126993288L;

    private Long id;

    private String name;

    private String message;

    private List<User> userList;

}
