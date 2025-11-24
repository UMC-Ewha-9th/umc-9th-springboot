package com.example.umc_mission.domain.member.controller;

import com.example.umc_mission.domain.member.dto.MemberReqDto;
import com.example.umc_mission.domain.member.dto.MemberResDto;
import com.example.umc_mission.domain.member.exception.code.MemberSuccessCode;
import com.example.umc_mission.domain.member.service.command.MemberCommandService;
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

    // DTO 유효성 검사
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ApiResponse<Map<String, String>>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex
    ) {
        // 검사에 실패한 필드와 메시지 저장 Map
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        GeneralErrorCode code = GeneralErrorCode.VALID_FAIL;
        ApiResponse<Map<String, String>> errorResponse = ApiResponse.onFailure(code);

        // 에러코드, 메시지와 함께 error 반환
        return ResponseEntity.status(code.getStatus()).body(errorResponse);
    }

    // 회원가입
    @PostMapping("/sign-up")
    public ApiResponse<MemberResDto.MemberJoinDto> signUp(
            @RequestBody @Valid MemberReqDto.MemberJoinDto dto
    ) {
        return ApiResponse.onSuccess(MemberSuccessCode.FOUND, memberCommandService.signUp(dto));
    }

}
