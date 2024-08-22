package com.shop.shoppingMall.shop.service;

import com.shop.shoppingMall.shop.dto.ProductDto;
import com.shop.shoppingMall.shop.entity.ProductEntity;
import com.shop.shoppingMall.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository productRepository;


    public Long save(ProductDto productDto) {
        ProductEntity productEntity = ProductEntity.toEntity(productDto);
        productEntity = productRepository.save(productEntity);
        return productEntity.getId();
    }

    @Transactional(readOnly = true)
    public List<ProductDto> list() {
        List<ProductEntity> productEntityList = productRepository.findAll();
        List<ProductDto> productDtoList = productEntityList.stream().map(ProductDto::toDto).toList();
        return productDtoList;
    }

}