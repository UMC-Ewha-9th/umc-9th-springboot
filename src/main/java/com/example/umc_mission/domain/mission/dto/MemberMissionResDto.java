package com.example.umc_mission.domain.mission.dto;

import com.example.umc_mission.domain.mission.enums.Status;
import lombok.Builder;

public class MemberMissionResDto {

    @Builder
    public record addMemberMissionDto(
            Long memberId,
            Long missionId,
            Status status
    ){}

}
