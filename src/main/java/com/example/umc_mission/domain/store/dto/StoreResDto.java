package com.example.umc_mission.domain.store.dto;

import lombok.Builder;

public class StoreResDto {

    @Builder
    public record addStoreDto(
            Long storeId
    ){}

}
