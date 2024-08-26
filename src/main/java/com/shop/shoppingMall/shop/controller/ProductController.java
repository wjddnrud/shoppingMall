package com.shop.shoppingMall.shop.controller;

import com.shop.shoppingMall.shop.dto.ProductDto;
import com.shop.shoppingMall.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/shop")
public class ProductController {

    private final ProductService productService;


    // 상품 등록폼
    @PostMapping("/product")
    public String save(ProductDto productDto, Model model) {
        productService.save(productDto);
        return "redirect:/product";
    }

    // 상품 리스트
    @GetMapping("/product")
    public String list(Model model) {
        model.addAttribute("productList", productService.list());
        return "productList";
    }

    // 상품 상세
    @GetMapping("/product/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("product", productService.findById(id));
        return "products/view";
    }


}
