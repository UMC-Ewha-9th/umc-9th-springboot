package com.example.umc9th.domain.usermission.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum UsermissionErrorCode implements BaseErrorCode {

    USERMISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "USERMISSION404_1", "유저미션을 찾을 수 없습니다."),
    INVALID_USERMISSION(HttpStatus.BAD_REQUEST, "USERMISSION400_1", "유효하지 않은 유저미션입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
