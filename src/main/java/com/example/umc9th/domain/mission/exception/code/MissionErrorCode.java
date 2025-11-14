package com.example.umc9th.domain.mission.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MissionErrorCode implements BaseErrorCode {

    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "Mission404_1", "미션을 찾을 수 없습니다."),
    MISSION_INVALID(HttpStatus.BAD_REQUEST, "Mission400_1", "유효하지 않은 미션 요청입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
