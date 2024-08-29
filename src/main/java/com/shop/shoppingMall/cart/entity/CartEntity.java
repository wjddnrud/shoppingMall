package com.shop.shoppingMall.cart.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity(name = "cart")
@Getter
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;
}
