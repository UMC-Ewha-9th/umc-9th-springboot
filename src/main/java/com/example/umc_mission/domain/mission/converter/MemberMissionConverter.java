package com.example.umc_mission.domain.mission.converter;

import com.example.umc_mission.domain.member.entity.Member;
import com.example.umc_mission.domain.mission.dto.MemberMissionReqDto;
import com.example.umc_mission.domain.mission.dto.MemberMissionResDto;
import com.example.umc_mission.domain.mission.entity.Mission;
import com.example.umc_mission.domain.mission.entity.mapping.MemberMission;
import com.example.umc_mission.domain.mission.enums.Status;
import org.springframework.data.domain.Page;

public class MemberMissionConverter {

    // Entity -> Dto
    public static MemberMissionResDto.addMemberMissionDto toAddMemberMissionDto(
        MemberMission memberMission
    ){
        return MemberMissionResDto.addMemberMissionDto.builder()
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .status(memberMission.getStatus())
                .build();
    }

    // Dto -> Entity
    public static MemberMission toMemberMission(
            Member member,
            Mission mission
    ){
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(Status.onProgress)
                .build();
    }

    // result -> Dto
    public static MemberMissionResDto.myMissionPreviewListDto toMyMissionPreviewListDto(
            Page<MemberMission> result
    ){
        return MemberMissionResDto.myMissionPreviewListDto.builder()
                .myMissionList(result.getContent().stream()
                        .map(MemberMissionConverter::toMyMissionPreviewDto)
                        .toList())
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .totalElement(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }

    public static MemberMissionResDto.myMissionPreviewDto toMyMissionPreviewDto(
            MemberMission memberMission
    ){
        return MemberMissionResDto.myMissionPreviewDto.builder()
                .memberMissionId(memberMission.getId())
                .status(memberMission.getStatus())
                .storeName(memberMission.getMission().getStore().getName())
                .conditional(memberMission.getMission().getConditional())
                .point(memberMission.getMission().getPoint())
                .deadline(memberMission.getMission().getDeadline())
                .build();
    }

}
