package com.example.umc9th.domain.review.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ReviewErrorCode implements BaseErrorCode {

    REVIEW_NOT_FOUND(HttpStatus.NOT_FOUND, "REVIEW404_1", "리뷰를 찾을 수 없습니다."),
    INVALID_REVIEW(HttpStatus.BAD_REQUEST, "REVIEW400_1", "유효하지 않은 리뷰 요청입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
