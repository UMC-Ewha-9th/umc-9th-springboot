package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.entity.MissionChallenge;
import com.example.umc9th.domain.mission.entity.enums.ChallengeStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionChallengeRepository extends JpaRepository<MissionChallenge, Long> {

    Page<MissionChallenge> findAllByUser_IdAndStatus(
            Long userId,
            ChallengeStatus status,
            Pageable pageable
    );
}
