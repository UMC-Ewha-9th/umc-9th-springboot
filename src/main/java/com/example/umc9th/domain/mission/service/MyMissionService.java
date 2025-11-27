package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.mission.dto.MyMissionResDTO;

public interface MyMissionService {
    MyMissionResDTO.ChallengeListDTO getMyInProgress(Long userId, Integer page);
}
