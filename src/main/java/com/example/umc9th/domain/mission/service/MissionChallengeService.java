package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.mission.dto.MissionChallengeReqDTO;
import com.example.umc9th.domain.mission.dto.MissionChallengeResDTO;

public interface MissionChallengeService {

    MissionChallengeResDTO.CreateDTO challenge(Long missionId, MissionChallengeReqDTO.CreateDTO dto);
}
