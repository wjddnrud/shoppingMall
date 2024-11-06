package com.shop.shoppingMall.board.controller;

import com.shop.shoppingMall.board.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/notice")
public class NoticeController {

    private final NoticeService noticeService;

    /**
     * 공지사항 목록
     * @param model
     * @return
     */
    @GetMapping("/")
    public String noticeList(Model model) {
        noticeService.list(model);
        return "/board/notice/list";
    }

    /**
     * 공지사항 등록 폼
     * @return
     */
    @GetMapping("/form")
    public String noticeForm() {
        return "";
    }


}
