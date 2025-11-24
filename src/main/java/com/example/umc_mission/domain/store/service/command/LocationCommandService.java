package com.example.umc_mission.domain.store.service.command;

import com.example.umc_mission.domain.store.dto.LocationReqDto;
import com.example.umc_mission.domain.store.dto.LocationResDto;

public interface LocationCommandService {
    // 지역 추가
    LocationResDto.addLocationDto addLocation(
            LocationReqDto.addLocationDto dto
    );
}
