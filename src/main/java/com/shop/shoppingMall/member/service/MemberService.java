package com.shop.shoppingMall.member.service;

import com.shop.shoppingMall.member.dto.MemberDto;
import com.shop.shoppingMall.member.entity.MemberEntity;
import com.shop.shoppingMall.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;


    public void loginProcess(MemberDto memberDto) {
        MemberEntity memberEntity = MemberEntity.toEntity(memberDto);
        Boolean duplicateCheck = memberRepository.findByLoginId(memberEntity.getLoginId());
        if (!duplicateCheck) {
            log.info("===== 이미 존재하는 회원입니다. =====");
        }
    }
}
