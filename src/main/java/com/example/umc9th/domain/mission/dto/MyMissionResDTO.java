package com.example.umc9th.domain.mission.dto;

import lombok.Builder;
import java.time.LocalDateTime;
import java.util.List;

public class MyMissionResDTO {

    @Builder
    public record ChallengeListDTO(
            List<ChallengeDTO> challenges,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ) {}

    @Builder
    public record ChallengeDTO(
            Long challengeId,
            Long missionId,
            String missionTitle,
            LocalDateTime createdAt
    ) {}
}
