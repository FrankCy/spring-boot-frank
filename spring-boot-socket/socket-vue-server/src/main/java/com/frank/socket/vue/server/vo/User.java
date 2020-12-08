package com.frank.socket.vue.server.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 *
 *
 * @author cy
 * @version User.java, v 0.1 2020年12月08日 3:04 下午 cy Exp $
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 6494362039808224405L;

    private Integer id;

    private String name;

    private Integer age;

    private String description;

}
