package com.shop.shoppingMall.shop.controller;

import com.shop.shoppingMall.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/shop")
public class ProductController {

    private final ProductService productService;

    // 상품 리스트
    // 상품 상세
    // 상품 등록

}
