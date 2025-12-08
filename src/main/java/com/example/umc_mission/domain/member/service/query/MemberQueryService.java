package com.example.umc_mission.domain.member.service.query;

import com.example.umc_mission.domain.member.dto.MemberReqDto;
import com.example.umc_mission.domain.member.dto.MemberResDto;
import jakarta.validation.Valid;

public interface MemberQueryService {

    MemberResDto.LoginDto login(
            MemberReqDto.@Valid LoginDto dto
    );
}
