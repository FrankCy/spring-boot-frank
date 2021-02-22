package com.frank.distributed.subdatabasetable.dao;

import com.frank.distributed.subdatabasetable.entity.OrderMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 *
 * @author cy
 * @version OrderRepository.java, v 0.1 2021年02月20日 2:55 下午 cy Exp $
 */
public interface OrderMainRepository extends JpaRepository<OrderMain, Long>,
        JpaSpecificationExecutor<OrderMain> {

}