package com.dmsdbj.order.repository;

import com.dmsdbj.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ${DESCRIPTION}
 *
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-08-20
 */

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
