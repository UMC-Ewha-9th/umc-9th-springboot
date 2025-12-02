package com.example.umc_mission.domain.mission.service.query;

import com.example.umc_mission.domain.mission.dto.MissionResDto;
import jakarta.transaction.Transactional;

public interface MissionQueryService {
    // 가게 미션 목록 조회
    @Transactional
    MissionResDto.MissionPreviewListDto getMissionsByStore(
            String storeName,
            Integer page
    );
}
