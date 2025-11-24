package com.example.umc_mission.domain.store.dto;

import lombok.Builder;

public class LocationResDto {

    @Builder
    public record addLocationDto(
        Long locationId,
        String name
    ){}

}
