package com.shop.shoppingMall.member.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class MemberDto {

    private Long id;                            // COMMENT :: 고유값
    private String loginId;                     // COMMENT :: 로그인 아이디
    private String password;                    // COMMENT :: 패스워드
    private String nickName;                    // COMMENT :: 닉네임
    private String name;                        // COMMENT :: 회원명
    private String gender;                      // COMMENT :: 성별
    private String birth;                       // COMMENT :: 생년월일
    private LocalDateTime regDate;              // COMMENT :: 등록일자

}
