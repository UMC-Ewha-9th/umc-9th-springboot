package com.example.umc_mission.domain.mission.dto;

import com.example.umc_mission.domain.mission.enums.Status;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

public class MemberMissionResDto {

    @Builder
    public record addMemberMissionDto(
            Long memberId,
            Long missionId,
            Status status
    ){}

    @Builder
    public record myMissionPreviewListDto(
            List<myMissionPreviewDto> myMissionList,
            Integer listSize,
            Integer totalPage,
            Long totalElement,
            Boolean isFirst,
            Boolean isLast
    ){}

    @Builder
    public record myMissionPreviewDto(
            Long memberMissionId,
            Status status,
            String storeName,
            String conditional,
            Integer point,
            LocalDate deadline
    ){}



}
