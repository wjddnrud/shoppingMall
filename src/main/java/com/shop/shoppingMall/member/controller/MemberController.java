package com.shop.shoppingMall.member.controller;

import com.shop.shoppingMall.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {


    @GetMapping("/login")
    public String loginForm() {
        log.info("===== loginForm =====");
        return "login";
    }

    @PostMapping("/login")
    public String loginProcess(Model model, MemberDto memberDto) {
        log.info("===== loginProcess =====");

        return "redirect:/home";
    }


}
