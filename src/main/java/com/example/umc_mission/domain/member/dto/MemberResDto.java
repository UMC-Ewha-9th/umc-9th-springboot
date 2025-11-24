package com.example.umc_mission.domain.member.dto;

import lombok.Builder;

import java.time.LocalDateTime;

public class MemberResDto {

    @Builder
    public record MemberJoinDto(
            Long memberId,
            LocalDateTime createdAt
    ){}

}
