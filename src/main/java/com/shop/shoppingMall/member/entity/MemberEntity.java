package com.shop.shoppingMall.member.entity;

import com.shop.shoppingMall.member.dto.MemberDto;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Member")
@Getter
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;                            // COMMENT :: 고유값
    private String loginId;                     // COMMENT :: 로그인 아이디
    private String password;                    // COMMENT :: 패스워드
    private String nickName;                    // COMMENT :: 닉네임
    private String name;                        // COMMENT :: 회원명
    private String gender;                      // COMMENT :: 성별
    private String birth;                       // COMMENT :: 생년월일
    private LocalDateTime regDate;              // COMMENT :: 등록일자


    public static MemberEntity toEntity(MemberDto memberDto) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.id = memberDto.getId();
        memberEntity.loginId = memberDto.getLoginId();
        memberEntity.password = memberDto.getPassword();
        memberEntity.nickName = memberDto.getNickName();
        memberEntity.name = memberDto.getName();
        memberEntity.gender = memberDto.getGender();
        memberEntity.birth = memberDto.getBirth();
        memberEntity.regDate = LocalDateTime.now();
        return memberEntity;
    }
}
