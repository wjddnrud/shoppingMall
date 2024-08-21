package com.shop.shoppingMall.shop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity(name = "product")
@Getter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                    // COMMENT :: 상품 고유값
    private String name;                // COMMENT :: 상품명
    private int price;                  // COMMENT :: 상품 가격
    private int stockQuantity;          // COMMENT :: 재고 수량
    private String description;         // COMMENT :: 설명
    private LocalDateTime regDate;      // COMMENT :: 등록일자
}
