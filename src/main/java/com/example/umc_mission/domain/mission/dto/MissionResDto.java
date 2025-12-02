package com.example.umc_mission.domain.mission.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MissionResDto {

    @Builder
    public record addMissionDto(
            Long storeId,
            String conditional,
            Integer point,
            LocalDate deadline,
            LocalDateTime createdAt
    ){}

    @Builder
    public record MissionPreviewListDto(
            List<MissionPreviewDto> missionList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}

    @Builder
    public record MissionPreviewDto(
            String conditional,
            Integer point,
            LocalDate deadline
    ){}

}
