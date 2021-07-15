package com.frank.mongodb.pojo;

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
 * @version SmsLogResult.java, v 0.1 2021年07月15日 10:51 上午 cy Exp $
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SmsLogResult implements Serializable {

    private static final long serialVersionUID = 5908955854854718338L;

    private String id;

    private Integer totalCount;

    private Integer successCount;

    private Integer errorCount;

    private Double sumPrice;

}
