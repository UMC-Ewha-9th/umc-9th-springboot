package com.example.umc9th.domain.mission.dto;

import jakarta.validation.constraints.NotNull;

public class MissionChallengeReqDTO {

    public record CreateDTO(
            @NotNull Long userId
    ) {}
}
