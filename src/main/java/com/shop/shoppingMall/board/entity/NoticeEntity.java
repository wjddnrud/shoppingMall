package com.shop.shoppingMall.board.entity;

import com.shop.shoppingMall.board.dto.NoticeDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Entity
@Table(name = "notice")
@Getter
@Data
public class NoticeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String title;
    private String content;
    private String writer;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Builder
    public void toEntity(NoticeDto noticeDto) {
        this.idx = noticeDto.getIdx();
        this.title = noticeDto.getTitle();
        this.content = noticeDto.getContent();
        this.writer = noticeDto.getWriter();
        this.createTime = new Date();
    }
}
