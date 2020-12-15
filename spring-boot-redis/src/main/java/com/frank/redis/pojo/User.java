package com.frank.redis.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 *
 * @author cy
 * @version User.java, v 0.1 2020年12月15日 11:57 上午 cy Exp $
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String id;

    private String name;

    private String tel;

}
