package com.example.umc_mission.domain.review.exception;

import com.example.umc_mission.global.apiPayload.code.BaseErrorCode;
import com.example.umc_mission.global.apiPayload.exception.GeneralException;

public class ReviewException extends GeneralException {
    public ReviewException(BaseErrorCode code) {
        super(code);
    }
}
