package com.example.umc_mission.domain.store.exception.code;

import com.example.umc_mission.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum LocationSuccessCode implements BaseSuccessCode {

    FOUND(HttpStatus.OK,
            "LOCATION200_1",
            "성공적으로 지역을 조회했습니다."),
    CREATED(HttpStatus.CREATED,
            "LOCATION201_1",
            "성공적으로 지역을 추가했습니다.")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;

}
