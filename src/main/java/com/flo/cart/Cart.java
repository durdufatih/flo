package com.flo.cart;

import com.flo.product.Product;

import javax.persistence.*;

/**
 * Created by fatihdurdu on 08/02/17.
 */
@Entity
@Table(name="tbl_cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade= CascadeType.ALL)
    private Product product;

    public Cart(Product product) {
        this.product = product;
    }

    public Cart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
