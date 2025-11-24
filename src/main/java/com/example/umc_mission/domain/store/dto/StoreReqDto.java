package com.example.umc_mission.domain.store.dto;

import com.example.umc_mission.domain.store.enums.Type;

public class StoreReqDto {

    public record addStoreDto(
            String name,
            Type type,
            Long managerNumber,
            String detailAddress,
            Long locationId
    ){}

}
