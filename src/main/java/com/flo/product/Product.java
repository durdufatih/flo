package com.flo.product;

import javax.persistence.*;

/**
 * Created by fatihdurdu on 07/02/17.
 */
@Entity
@Table(name="group_table")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String description;
    private double price;
    private String currency;

    public Product(String currency, String description, String name, double price) {
        this.currency = currency;
        this.description = description;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
