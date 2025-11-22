package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.mission.dto.MissionChallengeReqDTO;
import com.example.umc9th.domain.mission.dto.MissionChallengeResDTO;
import com.example.umc9th.domain.mission.entity.MissionChallenge;
import com.example.umc9th.domain.mission.entity.enums.ChallengeStatus;
import com.example.umc9th.domain.mission.repository.MissionChallengeRepository;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.mission.converter.MissionChallengeConverter;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MissionChallengeServiceImpl implements MissionChallengeService {

    private final MissionRepository missionRepository;
    private final MissionChallengeRepository missionChallengeRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public MissionChallengeResDTO.CreateDTO challenge(Long missionId, MissionChallengeReqDTO.CreateDTO dto) {

        User user = userRepository.findById(1L)   // 하드코딩
                .orElseThrow(() -> new RuntimeException("User not found"));

        var mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new RuntimeException("Mission not found"));

        MissionChallenge challenge = MissionChallenge.builder()
                .mission(mission)
                .user(user)
                .status(ChallengeStatus.IN_PROGRESS)
                .build();

        missionChallengeRepository.save(challenge);

        return MissionChallengeConverter.toCreateDTO(challenge);
    }
}
