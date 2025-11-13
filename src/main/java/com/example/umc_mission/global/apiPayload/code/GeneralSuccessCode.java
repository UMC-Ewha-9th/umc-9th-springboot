package com.example.umc_mission.global.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GeneralSuccessCode implements BaseSuccessCode {

    OK(HttpStatus.OK,
            "COMMON200_1",
            "요청이 성공적으로 처리되었습니다."),
    CREATED(HttpStatus.CREATED,
            "COMMON201_1",
            "리소스가 성공적으로 생성되었습니다."),
    ACCEPTED(HttpStatus.ACCEPTED,
            "COMMON202_1",
            "요청이 정상 수신되어, 곧 처리될 예정입니다."),
    NON_AUTHORITATIVE_INFORMATION(HttpStatus.NON_AUTHORITATIVE_INFORMATION,
            "COMMON203_1",
            "요청이 성공적으로 처리되었으나 반환된 정보가 원본 서버의 권한 있는 정보가 아닙니다."),
    NO_CONTENT(HttpStatus.NO_CONTENT,
            "COMMON204_1",
            "요청이 성공적으로 처리되었으나 반환할 콘텐츠가 없습니다."),
    RESET_CONTENT(HttpStatus.RESET_CONTENT,
            "COMMON205_1",
            "요청이 성공적으로 처리되어 클라이언트는 뷰를 초기화해야 합니다."),
    PARTIAL_CONTENT(HttpStatus.PARTIAL_CONTENT,
            "COMMON206_1",
            "리소스의 일부가 성공적으로 반환되었습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;

}
