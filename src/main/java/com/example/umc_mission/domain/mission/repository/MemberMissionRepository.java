package com.example.umc_mission.domain.mission.repository;

import com.example.umc_mission.domain.member.entity.Member;
import com.example.umc_mission.domain.mission.entity.mapping.MemberMission;
import com.example.umc_mission.domain.mission.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    Optional<MemberMission> findByMemberAndId(Member member, Long memberMissionId);

    Page<MemberMission> findAllByMemberAndStatus(Member member, Status status, PageRequest pageRequest);

}