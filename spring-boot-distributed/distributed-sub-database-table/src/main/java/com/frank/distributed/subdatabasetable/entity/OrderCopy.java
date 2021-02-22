package com.frank.distributed.subdatabasetable.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 *
 * @author cy
 * @version OrderCopy.java, v 0.1 2021年02月20日 3:04 下午 cy Exp $
 */
@Data
@Entity
@Table(name = "order_copy")
public class OrderCopy {

    @Id
    // 注释后不会使用自增主键，可以自定义主键（因为是实验分库分表操作，所以主键不能自增，这里注释掉）
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Integer userId;
}
