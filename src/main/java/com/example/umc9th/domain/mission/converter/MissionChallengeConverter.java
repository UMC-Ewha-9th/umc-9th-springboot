package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.mission.dto.MissionChallengeResDTO;
import com.example.umc9th.domain.mission.entity.MissionChallenge;

public class MissionChallengeConverter {

    public static MissionChallengeResDTO.CreateDTO toCreateDTO(MissionChallenge challenge) {
        return MissionChallengeResDTO.CreateDTO.builder()
                .challengeId(challenge.getId())
                .createdAt(challenge.getCreatedAt())
                .build();
    }
}
