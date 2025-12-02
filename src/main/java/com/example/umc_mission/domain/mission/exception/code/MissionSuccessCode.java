package com.example.umc_mission.domain.mission.exception.code;

import com.example.umc_mission.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MissionSuccessCode implements BaseSuccessCode {

    FOUND(HttpStatus.FOUND,
            "MISSION200_1",
            "성공적으로 미션을 조회했습니다."),
    CREATED(HttpStatus.CREATED,
            "MISSION201_1",
            "성공적으로 미션을 추가했습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;

}
