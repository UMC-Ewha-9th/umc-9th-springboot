package com.example.umc_mission.domain.mission.service.command;

import com.example.umc_mission.domain.mission.dto.MemberMissionReqDto;
import com.example.umc_mission.domain.mission.dto.MemberMissionResDto;

public interface MemberMissionCommandService {
    // 미션 도전
    MemberMissionResDto.addMemberMissionDto addMemberMission(
            MemberMissionReqDto.addMemberMissionDto dto
    );
}
