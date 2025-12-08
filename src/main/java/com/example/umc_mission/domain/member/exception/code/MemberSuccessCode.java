package com.example.umc_mission.domain.member.exception.code;

import com.example.umc_mission.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberSuccessCode implements BaseSuccessCode {

    FOUND(HttpStatus.FOUND,
            "MEMBER200_1",
            "성공적으로 회원을 조회했습니다."),
    CREATED(HttpStatus.CREATED,
            "MEMBER201_1",
            "회원가입에 성공했습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;

}
