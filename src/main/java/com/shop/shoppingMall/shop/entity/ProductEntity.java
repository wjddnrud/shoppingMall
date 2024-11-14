package com.shop.shoppingMall.shop.entity;

import com.shop.shoppingMall.exception.NotEnoughStockException;
import com.shop.shoppingMall.shop.dto.ProductDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@Getter
@Data
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;                    // COMMENT :: 상품 고유값
    private String name;                // COMMENT :: 상품명
    private int price;                  // COMMENT :: 상품 가격
    private int stockQuantity;          // COMMENT :: 재고 수량
    private String description;         // COMMENT :: 설명
    private LocalDateTime regDate;      // COMMENT :: 등록일자


    public static ProductEntity toEntity(ProductDto productDto) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.id = productDto.getId();
        productEntity.name = productDto.getName();
        productEntity.price = productDto.getPrice();
        productEntity.stockQuantity = productDto.getStockQuantity();
        productEntity.description = productDto.getDescription();
        productEntity.regDate = productDto.getRegDate();
        return productEntity;
    }

    /**
     * stockQuantity 증가
     * @param quantity
     */
    public void addStockQuantity(int quantity) {
        this.stockQuantity += quantity;
    }

    /**
     * stockQuantity 감소
     * @param quantity
     */
    public void removeStockQuantity(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if(restStock < 0) {
            throw new NotEnoughStockException("Need more stock");
        }
        this.stockQuantity = restStock;
    }
}
