package com.shop.shoppingMall.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BaseController {


    @RequestMapping("/")
    public String home() {
        log.info("main 페이지 html로 이동");
        return "main";
    }

}
