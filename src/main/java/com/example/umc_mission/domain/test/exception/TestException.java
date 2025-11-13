package com.example.umc_mission.domain.test.exception;

import com.example.umc_mission.global.apiPayload.code.BaseErrorCode;
import com.example.umc_mission.global.apiPayload.exception.GeneralException;

public class TestException extends GeneralException {

    public TestException(BaseErrorCode code) {
        super(code);
    }

}
