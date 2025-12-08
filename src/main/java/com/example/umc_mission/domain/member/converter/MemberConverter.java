package com.example.umc_mission.domain.member.converter;

import com.example.umc_mission.domain.member.dto.MemberReqDto;
import com.example.umc_mission.domain.member.dto.MemberResDto;
import com.example.umc_mission.domain.member.entity.Member;
import com.example.umc_mission.domain.member.enums.Role;

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
            MemberReqDto.MemberJoinDto dto,
            String password,
            Role role
    ) {
        return Member.builder()
                .name(dto.name())
                .email(dto.email())
                .password(password)
                .role(role)
                .birth(dto.birth())
                .address(dto.address())
                .detailAddress(dto.detailAddress())
                .gender(dto.gender())
                .build();
    }

    // 로그인
    public static MemberResDto.LoginDto toLoginDto(
            Member member,
            String accessToken
    ){
        return MemberResDto.LoginDto.builder()
                .memberId(member.getId())
                .accessToken(accessToken)
                .build();
    }

}
