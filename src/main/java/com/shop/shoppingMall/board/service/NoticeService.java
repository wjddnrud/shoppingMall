package com.shop.shoppingMall.board.service;

import com.shop.shoppingMall.board.dto.NoticeDto;
import com.shop.shoppingMall.board.entity.NoticeEntity;
import com.shop.shoppingMall.board.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class NoticeService {
    private final NoticeRepository noticeRepository;


    @Transactional(readOnly = true)
    public List<NoticeDto> list(Model model) {
        List<NoticeEntity> noticeEntityList = noticeRepository.findAll();
        log.info("noticeEntityList : " + noticeEntityList);
        List<NoticeDto> noticeDtoList = noticeEntityList.stream().map(NoticeDto::new).collect(Collectors.toList());
        model.addAttribute("noticeList", noticeDtoList);
        log.info("noticeList : " + noticeDtoList);
        return noticeDtoList;
    }

}
