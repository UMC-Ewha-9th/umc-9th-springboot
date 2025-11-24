package com.example.umc_mission.domain.store.exception;

import com.example.umc_mission.global.apiPayload.code.BaseErrorCode;
import com.example.umc_mission.global.apiPayload.exception.GeneralException;

public class LocationException extends GeneralException {
    public LocationException(BaseErrorCode code) {
        super(code);
    }
}
