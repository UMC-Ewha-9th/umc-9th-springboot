package com.example.umc_mission.domain.mission.service.command;

import com.example.umc_mission.domain.mission.dto.MemberMissionResDto;
import com.example.umc_mission.global.config.CustomUserDetails;
import jakarta.transaction.Transactional;

public interface MemberMissionCommandService {
    // 미션 도전
    MemberMissionResDto.addMemberMissionDto addMemberMission(
            CustomUserDetails user,
            Long missionId
    );

    // 미션 완료
    @Transactional
    MemberMissionResDto.myMissionPreviewListDto completeMemberMission(
            CustomUserDetails user,
            Long memberMissionId
    );
}
