package com.flo.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by fatihdurdu on 08/02/17.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
}
