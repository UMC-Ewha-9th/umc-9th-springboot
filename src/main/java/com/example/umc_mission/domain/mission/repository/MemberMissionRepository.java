package com.example.umc_mission.domain.mission.repository;

import com.example.umc_mission.domain.mission.entity.mapping.MemberMission;
import com.example.umc_mission.domain.mission.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    //내 미션 목록 조회
    Page<MemberMission> findByMemberIdAndStatus(Long memberId, Status status, Pageable pageable);

}