package com.shop.shoppingMall.shop.dto;

import com.shop.shoppingMall.shop.entity.ProductEntity;
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


    public static ProductDto toDto(ProductEntity productEntity) {
        ProductDto productDto = new ProductDto();
        productDto.id = productEntity.getId();
        productDto.name = productEntity.getName();
        productDto.price = productEntity.getPrice();
        productDto.stockQuantity = productEntity.getStockQuantity();
        productDto.description = productEntity.getDescription();
        productDto.regDate = productEntity.getRegDate();
        return productDto;
    }
}
