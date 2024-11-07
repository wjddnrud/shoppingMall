package com.shop.shoppingMall.board.controller;

import com.shop.shoppingMall.board.dto.NoticeDto;
import com.shop.shoppingMall.board.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/notice")
@Log4j2
public class NoticeController {

    private final NoticeService noticeService;

    /**
     * 공지사항 목록
     * @param model
     * @return
     */
    @GetMapping
    public String noticeList(Model model) {
        log.info("==================BoardController==================");
        noticeService.list(model);
        return "/board/notice/list";
    }

    /**
     * 공지사항 상세 조회
     * @param idx
     * @param model
     * @return
     */
    @GetMapping("/{idx}")
    public String noticeView(@PathVariable("idx") Long idx, Model model) {
        noticeService.findOne(idx, model);
        return "/board/notice/view";
    }


    /**
     * 공지사항 등록 폼
     * @return
     */
    @GetMapping("/form")
    public String noticeForm() {
        return "";
    }


    /**
     * 공지사항 등록
     * @param noticeDto
     * @return
     */
    @PostMapping
    public String noticeSave(NoticeDto noticeDto) {
        noticeService.save(noticeDto);
        return "redirect:/board/notice";
    }

    /**
     * 공지사항 수정
     * @param noticeDto
     * @return
     */
    @PostMapping("/update")
    public String noticeUpdate(NoticeDto noticeDto) {
        noticeService.update(noticeDto);
        return "";
    }

    /**
     * 공지사항 삭제
     * @param idx
     * @return
     */
    @DeleteMapping("/{idx}")
    public String noticeDelete(@PathVariable("idx") Long idx) {
        noticeService.delete(idx);
        return "redirect:/board/notice";
    }



}
