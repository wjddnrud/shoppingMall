package com.shop.shoppingMall.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class securityTestController {

    @GetMapping("/api1")
    public ResponseEntity api1() {
        return new ResponseEntity<>("api1입니다.", HttpStatus.OK);
    }

    @GetMapping("/api2")
    public ResponseEntity api2() {
        return new ResponseEntity<>("api2입니다.", HttpStatus.OK);
    }
}
