package com.example.umc_mission.domain.member.converter;

import com.example.umc_mission.domain.member.dto.MemberReqDto;
import com.example.umc_mission.domain.member.dto.MemberResDto;
import com.example.umc_mission.domain.member.entity.Member;

public class MemberConverter {

    // Entity -> DTO
    public static MemberResDto.MemberJoinDto toJoinDto(
            Member member
    ) {
        return MemberResDto.MemberJoinDto.builder()
                .memberId(member.getId())
                .createdAt(member.getCreatedAt())
                .build();
    }

    // DTO -> Entity
    public static Member toMember(
            MemberReqDto.MemberJoinDto dto
    ) {
        return Member.builder()
                .name(dto.name())
                .birth(dto.birth())
                .address(dto.address())
                .detailAddress(dto.detailAddress())
                .gender(dto.gender())
                .build();
    }

}
