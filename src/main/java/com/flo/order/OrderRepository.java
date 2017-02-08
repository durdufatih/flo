package com.flo.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by fatihdurdu on 08/02/17.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
