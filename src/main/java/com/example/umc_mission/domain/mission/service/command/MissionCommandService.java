package com.example.umc_mission.domain.mission.service.command;

import com.example.umc_mission.domain.mission.dto.MissionReqDto;
import com.example.umc_mission.domain.mission.dto.MissionResDto;
import jakarta.transaction.Transactional;

public interface MissionCommandService {
    // 미션 추가
    @Transactional
    MissionResDto.addMissionDto addMission(
            MissionReqDto.addMissionDto dto
    );
}
