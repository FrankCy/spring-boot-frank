package com.frank.distributed.subdatabasetable.dao;

import com.frank.distributed.subdatabasetable.entity.OrderCopy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 *
 * @author cy
 * @version OrderCopyRepository.java, v 0.1 2021年02月20日 3:05 下午 cy Exp $
 */
public interface OrderCopyRepository extends JpaRepository<OrderCopy, Long>,
        JpaSpecificationExecutor<OrderCopy> {

}