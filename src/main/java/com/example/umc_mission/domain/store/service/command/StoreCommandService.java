package com.example.umc_mission.domain.store.service.command;

import com.example.umc_mission.domain.store.dto.StoreReqDto;
import com.example.umc_mission.domain.store.dto.StoreResDto;

public interface StoreCommandService {

    // 가게 추가
    StoreResDto.addStoreDto addStore(
            StoreReqDto.addStoreDto dto
    );
}
