package com.example.umc_mission.domain.mission.exception.code;

import com.example.umc_mission.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberMissionSuccessCode implements BaseSuccessCode {

    FOUND(HttpStatus.FOUND,
            "MEMBERMISSION200_1",
            "성공적으로 유저 미션을 조회했습니다."),
    OK(HttpStatus.OK,
            "MEMBERMISSION200_2",
            "성공적으로 유저 미션을 업데이트했습니다."),
    CREATED(HttpStatus.CREATED,
            "MEMBERMISSION201_1",
            "성공적으로 유저 미션을 추가했습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;

}
