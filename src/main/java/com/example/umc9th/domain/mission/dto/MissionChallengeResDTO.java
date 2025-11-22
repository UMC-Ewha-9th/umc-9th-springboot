package com.example.umc9th.domain.mission.dto;

import lombok.Builder;
import java.time.LocalDateTime;

public class MissionChallengeResDTO {

    @Builder
    public record CreateDTO(
            Long challengeId,
            LocalDateTime createdAt
    ) {}
}
