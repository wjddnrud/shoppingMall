package com.shop.shoppingMall.board.dto;

import com.shop.shoppingMall.board.entity.NoticeEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@Data
public class NoticeDto {

    private Long idx;
    private String title;
    private String content;
    private String writer;
    private Date createTime;

    // 기본 생성자 추가
    public NoticeDto() {}

    public NoticeDto (NoticeEntity noticeEntity) {
        this.idx = noticeEntity.getIdx();
        this.title = noticeEntity.getTitle();
        this.content = noticeEntity.getContent();
        this.writer = noticeEntity.getWriter();
        this.createTime = noticeEntity.getCreateTime();
    }
}
