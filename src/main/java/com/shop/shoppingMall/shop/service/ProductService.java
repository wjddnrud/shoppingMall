package com.shop.shoppingMall.shop.service;

import com.shop.shoppingMall.shop.dto.ProductDto;
import com.shop.shoppingMall.shop.entity.ProductEntity;
import com.shop.shoppingMall.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;


    public Long save(ProductDto productDto) {
        ProductEntity productEntity = ProductEntity.toEntity(productDto);
        productEntity = productRepository.save(productEntity);
        return productEntity.getId();
    }

    @Transactional(readOnly = true)
    public Page<ProductDto> list(Model model, Pageable pageable) {

        // 페이지 고정값 설정
        int pageSize = 10;
        int pageNumber = pageable.getPageNumber();
        Pageable fixedPageable = PageRequest.of(pageNumber, pageSize);

        Page<ProductEntity> productEntityList = productRepository.findAll(fixedPageable);
        Page<ProductDto> productDtoList = productEntityList.map(ProductDto::new);

        // 조회된 리스트 정보로 페이지 정보 세팅
        int totalPages = productDtoList.getTotalPages();
        int currentPage = productDtoList.getNumber();
        int displayPageSize = 5;
        int startPage = Math.max(0, currentPage / displayPageSize * displayPageSize);
        int endPage = Math.min(startPage + displayPageSize, totalPages);

        model.addAttribute("productList", productDtoList);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("currentPage", currentPage);

//        List<ProductEntity> productEntityList = productRepository.findAll();
//        List<ProductDto> productDtoList = productEntityList.stream().map(ProductDto::toDto).toList();
        return productDtoList;
    }

    @Transactional(readOnly = true)
    public ProductDto findById(Long productId) {
        Optional<ProductEntity> productEntity = productRepository.findById(productId);
        ProductDto productDto = productEntity.map(ProductDto::new).orElse(null);
        return productDto;
    }

}