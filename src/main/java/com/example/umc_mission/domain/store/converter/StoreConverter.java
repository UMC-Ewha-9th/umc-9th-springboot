package com.example.umc_mission.domain.store.converter;

import com.example.umc_mission.domain.store.dto.StoreReqDto;
import com.example.umc_mission.domain.store.dto.StoreResDto;
import com.example.umc_mission.domain.store.entity.Store;

public class StoreConverter {

    // Entity -> DTO
    public static StoreResDto.addStoreDto toJoinDto(
            Store store
    ) {
        return StoreResDto.addStoreDto.builder()
                .storeId(store.getId())
                .build();
    }

    // DTO -> Entity
    public static Store toStore(
            StoreReqDto.addStoreDto dto
    ) {
        return Store.builder()
                .name(dto.name())
                .type(dto.type())
                .managerNumber(dto.managerNumber())
                .detailAddress(dto.detailAddress())
                .build();
    }

}
