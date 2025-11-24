package com.example.umc_mission.domain.member.exception;

import com.example.umc_mission.global.apiPayload.code.BaseErrorCode;
import com.example.umc_mission.global.apiPayload.exception.GeneralException;

public class MemberException extends GeneralException {
    public MemberException(BaseErrorCode code) {
        super(code);
    }
}
