package com.shop.shoppingMall.shop.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class ProductDto {

    private Long id;                    // COMMENT :: 상품 고유값
    private String name;                // COMMENT :: 상품명
    private int price;                  // COMMENT :: 상품 가격
    private int stockQuantity;          // COMMENT :: 재고 수량
    private String description;         // COMMENT :: 설명
    private LocalDateTime regDate;      // COMMENT :: 등록일자
}
