package com.example.umc_mission.domain.mission.exception;

import com.example.umc_mission.global.apiPayload.code.BaseErrorCode;
import com.example.umc_mission.global.apiPayload.exception.GeneralException;

public class MemberMissionException extends GeneralException {
    public MemberMissionException(BaseErrorCode code) {
        super(code);
    }
}
