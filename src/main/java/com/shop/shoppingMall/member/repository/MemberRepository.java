package com.shop.shoppingMall.member.repository;

import com.shop.shoppingMall.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    Boolean findByLoginId(String loginId);
}
