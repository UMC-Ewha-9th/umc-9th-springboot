package com.example.umc_mission.domain.member.service.command;

import com.example.umc_mission.domain.member.dto.MemberReqDto;
import com.example.umc_mission.domain.member.dto.MemberResDto;
import jakarta.transaction.Transactional;

public interface MemberCommandService {
    // 회원가입
    MemberResDto.MemberJoinDto signUp(
            MemberReqDto.MemberJoinDto dto
    );
}
