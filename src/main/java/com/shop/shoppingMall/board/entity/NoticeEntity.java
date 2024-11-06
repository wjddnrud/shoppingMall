package com.shop.shoppingMall.board.entity;

import jakarta.persistence.*;
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
}
