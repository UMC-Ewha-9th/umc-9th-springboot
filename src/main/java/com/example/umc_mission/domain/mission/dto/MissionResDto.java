package com.example.umc_mission.domain.mission.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MissionResDto {

    @Builder
    public record addMissionDto(
            Long storeId,
            String conditional,
            Integer point,
            LocalDate deadline,
            LocalDateTime createdAt
    ){}

}
