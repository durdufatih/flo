package com.flo.order;

import com.flo.product.Product;

import javax.persistence.*;

/**
 * Created by fatihdurdu on 08/02/17.
 */
@Entity
@Table(name="tbl_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade= CascadeType.ALL)
    private Product product;

    //Bu String formata veya timestampa cevrilecek
    private String orderDay;

    public Order(String orderDay, Product product) {
        this.orderDay = orderDay;
        this.product = product;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderDay() {
        return orderDay;
    }

    public void setOrderDay(String orderDay) {
        this.orderDay = orderDay;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
