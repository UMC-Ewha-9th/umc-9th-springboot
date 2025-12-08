package com.example.umc_mission.domain.member.controller;

import com.example.umc_mission.domain.member.dto.MemberReqDto;
import com.example.umc_mission.domain.member.dto.MemberResDto;
import com.example.umc_mission.domain.member.exception.code.MemberSuccessCode;
import com.example.umc_mission.domain.member.service.command.MemberCommandService;
import com.example.umc_mission.domain.member.service.query.MemberQueryService;
import com.example.umc_mission.global.apiPayload.ApiResponse;
import com.example.umc_mission.global.apiPayload.code.GeneralErrorCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    // 회원가입
    @PostMapping("/sign-up")
    public ApiResponse<MemberResDto.MemberJoinDto> signUp(
            @RequestBody @Valid MemberReqDto.MemberJoinDto dto
    ) {
        return ApiResponse.onSuccess(MemberSuccessCode.CREATED, memberCommandService.signUp(dto));
    }

    // 로그인
    @PostMapping("/login")
    public ApiResponse<MemberResDto.LoginDto> login(
            @RequestBody @Valid MemberReqDto.LoginDto dto
    ){
        return ApiResponse.onSuccess(MemberSuccessCode.FOUND, memberQueryService.login(dto));
    }

}
