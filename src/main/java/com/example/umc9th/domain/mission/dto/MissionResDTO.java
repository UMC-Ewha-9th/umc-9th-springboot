package com.example.umc9th.domain.mission.dto;

import lombok.Builder;
import java.time.LocalDateTime;
import java.util.List;

public class MissionResDTO {

    @Builder
    public record MissionListDTO(
            List<MissionDTO> missions,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ) {}

    @Builder
    public record MissionDTO(
            Long missionId,
            String title,
            boolean active,
            LocalDateTime startsAt,
            LocalDateTime endsAt
    ) {}
}
