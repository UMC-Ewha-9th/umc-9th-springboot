package com.example.umc9th.global.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum PageErrorCode implements BaseErrorCode {

    PAGE_REQUIRED(HttpStatus.BAD_REQUEST, "PAGE400_1", "page 파라미터는 필수입니다."),
    INVALID_PAGE(HttpStatus.BAD_REQUEST, "PAGE400_2", "page는 1 이상의 정수여야 합니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
