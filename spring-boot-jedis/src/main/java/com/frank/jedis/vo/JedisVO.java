package com.frank.jedis.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 *
 * @author cy
 * @version JedisVO.java, v 0.1 2020年12月23日 2:02 下午 cy Exp $
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JedisVO {

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
