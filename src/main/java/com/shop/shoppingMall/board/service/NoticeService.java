package com.shop.shoppingMall.board.service;

import com.shop.shoppingMall.board.dto.NoticeDto;
import com.shop.shoppingMall.board.entity.NoticeEntity;
import com.shop.shoppingMall.board.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<NoticeDto> list(Model model) {
        log.info("===== list ======");
        List<NoticeEntity> noticeEntityList = noticeRepository.findAll();
        List<NoticeDto> noticeDtoList = noticeEntityList.stream().map(NoticeDto::new).collect(Collectors.toList());
        model.addAttribute("noticeList", noticeDtoList);
        log.info("===== noticeDtoList  : " + noticeDtoList);
        return noticeDtoList;
    }

    /**
     * 공지사항 단건 조회
     * @param idx
     * @return
     */
    @Transactional(readOnly = true)
    public NoticeDto findOne(Long idx, Model model) {
        log.info("===== findOne ======");
        log.info("===== idx : " + idx);
        NoticeEntity noticeEntity = noticeRepository.findById(idx).orElse(null);
        log.info("===== noticeEntity : " + noticeEntity);
        NoticeDto noticeDto = null;
        if (noticeEntity != null) {
            noticeDto = new NoticeDto(noticeEntity);
        }
        model.addAttribute("noticeDto", noticeDto);
        log.info("===== noticeDto : " + noticeDto);
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
        log.info("===== delete ======");
        log.info("===== idx : " + idx);
        noticeRepository.deleteById(idx);
    }

}
