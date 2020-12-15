package com.frank.redis.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 *
 * @author cy
 * @version RedisTestVO.java, v 0.1 2020年12月15日 1:08 下午 cy Exp $
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RedisTestVO {

    /**
     * 操作标记
     * c：创建
     * r：查询
     * u：更新
     * d：删除
     */
    private String operationFlag;

    private String key;

}
