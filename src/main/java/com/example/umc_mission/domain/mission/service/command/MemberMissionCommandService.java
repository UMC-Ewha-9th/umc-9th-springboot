package com.example.umc_mission.domain.mission.service.command;

import com.example.umc_mission.domain.mission.dto.MemberMissionReqDto;
import com.example.umc_mission.domain.mission.dto.MemberMissionResDto;
import jakarta.transaction.Transactional;

public interface MemberMissionCommandService {
    // 미션 도전
    MemberMissionResDto.addMemberMissionDto addMemberMission(
            MemberMissionReqDto.addMemberMissionDto dto
    );

    // 미션 완료
    @Transactional
    MemberMissionResDto.myMissionPreviewListDto completeMemberMission(
            MemberMissionReqDto.completeMemberMissionDto dto
    );
}
