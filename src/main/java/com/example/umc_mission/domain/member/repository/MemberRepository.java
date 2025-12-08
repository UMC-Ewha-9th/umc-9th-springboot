package com.example.umc_mission.domain.member.repository;

import com.example.umc_mission.domain.member.entity.Member;
import com.example.umc_mission.domain.member.projection.MyPage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    //마이페이지 조회
    Optional<MyPage> findMyPageById(Long id);

    Optional<Member> findByEmail(String username);
}
