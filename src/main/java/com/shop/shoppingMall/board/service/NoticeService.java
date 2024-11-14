package com.shop.shoppingMall.board.service;

import com.shop.shoppingMall.board.dto.NoticeDto;
import com.shop.shoppingMall.board.entity.NoticeEntity;
import com.shop.shoppingMall.board.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class NoticeService {
    private final NoticeRepository noticeRepository;


    /**
     * 공지사항 목록 조회
     * @param model
     * @return
     */
    @Transactional(readOnly = true)
    public Page<NoticeDto> list(Model model, Pageable pageable) {
        // 페이지 고정값 설정
        int pageSize = 10;
        int pageNumber = pageable.getPageNumber();
        Pageable fixedPageable = PageRequest.of(pageNumber, pageSize);

        // 공지사항 글 리스트 조회
        Page<NoticeEntity> noticeEntityList = noticeRepository.findAll(fixedPageable);
        Page<NoticeDto> noticeDtoList = noticeEntityList.map(NoticeDto::new);

        // 조회된 리스트 정보로 페이지 정보 세팅
        int totalPages = noticeDtoList.getTotalPages();
        int currentPage = noticeDtoList.getNumber();
        int displayPageSize = 5;
        int startPage = Math.max(0, currentPage / displayPageSize * displayPageSize);
        int endPage = Math.min(startPage + displayPageSize, totalPages);

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("noticeList", noticeDtoList);

        return noticeDtoList;
    }

    /**
     * 공지사항 단건 조회
     * @param idx
     * @return
     */
    @Transactional(readOnly = true)
    public NoticeDto findOne(Long idx, Model model) {
        NoticeEntity noticeEntity = noticeRepository.findById(idx).orElse(null);
        NoticeDto noticeDto = null;
        if (noticeEntity != null) {
            noticeDto = new NoticeDto(noticeEntity);
            noticeDto.setContent(noticeDto.getContent().replaceAll("\n", "<br>"));
        }
        model.addAttribute("noticeDto", noticeDto);
        return noticeDto;
    }

    /**
     * 공지사항 등록
     * @param noticeDto
     */
    @Transactional
    public void save(NoticeDto noticeDto) {
        log.info("===== save ======");
        log.info("===== noticeDto : " + noticeDto);
        NoticeEntity noticeEntity = new NoticeEntity();
        noticeEntity.toEntity(noticeDto);
        noticeRepository.save(noticeEntity);
    }

    /**
     * 공지사항 수정
     * @param noticeDto
     * @return
     */
    @Transactional
    public NoticeDto update(NoticeDto noticeDto) {
        log.info("===== update ======");
        log.info("===== noticeDto : " + noticeDto);
        Optional<NoticeEntity> noticeEntity = noticeRepository.findById(noticeDto.getIdx());
        if (noticeEntity.isPresent()) {
            noticeEntity.get().toEntity(noticeDto);
            noticeRepository.save(noticeEntity.get());
        }
        return noticeDto;
    }

    /**
     * 공지사항 삭제
     * @param idx
     */
    @Transactional
    public void delete(Long idx) {
        noticeRepository.deleteById(idx);
    }

}
