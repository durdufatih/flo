package com.flo.cart;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fatihdurdu on 08/02/17.
 */
public interface CartRepository extends JpaRepository<Cart,Long> {

}
