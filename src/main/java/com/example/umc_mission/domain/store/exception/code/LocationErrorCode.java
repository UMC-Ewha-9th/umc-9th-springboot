package com.example.umc_mission.domain.store.exception.code;

import com.example.umc_mission.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum LocationErrorCode implements BaseErrorCode {

    NOT_FOUND(HttpStatus.NOT_FOUND,
            "LOCATION404_1",
            "해당 지역을 찾지 못했습니다."),
    CONFLICT(HttpStatus.CONFLICT,
            "LOCATION409_1",
            "이미 존재하는 지역입니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;

}
