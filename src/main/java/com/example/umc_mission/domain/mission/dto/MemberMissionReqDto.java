package com.example.umc_mission.domain.mission.dto;

import com.example.umc_mission.domain.mission.enums.Status;

public class MemberMissionReqDto {

    public record addMemberMissionDto(
            Long memberId,
            Long missionId,
            Status status
    ){}

    public record completeMemberMissionDto(
            Long memberId,
            Long memberMissionId
    ){}

}
