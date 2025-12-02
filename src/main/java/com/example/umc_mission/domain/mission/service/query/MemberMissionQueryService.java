package com.example.umc_mission.domain.mission.service.query;

import com.example.umc_mission.domain.mission.dto.MemberMissionResDto;
import com.example.umc_mission.domain.mission.enums.Status;
import jakarta.transaction.Transactional;

public interface MemberMissionQueryService {
    // 내가 도전 중인 미션 목록 조회
    @Transactional
    MemberMissionResDto.myMissionPreviewListDto getMyMissions(
            Long memberId,
            Status status,
            Integer page
    );
}
