package com.example.umc_mission.domain.mission.converter;

import com.example.umc_mission.domain.member.entity.Member;
import com.example.umc_mission.domain.mission.dto.MemberMissionReqDto;
import com.example.umc_mission.domain.mission.dto.MemberMissionResDto;
import com.example.umc_mission.domain.mission.entity.Mission;
import com.example.umc_mission.domain.mission.entity.mapping.MemberMission;

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
            MemberMissionReqDto.addMemberMissionDto dto,
            Member member,
            Mission mission
    ){
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(dto.status())
                .build();
    }

}
