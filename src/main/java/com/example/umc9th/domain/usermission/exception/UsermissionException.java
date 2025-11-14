package com.example.umc9th.domain.usermission.exception;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import com.example.umc9th.global.apiPayload.exception.GeneralException;

public class UsermissionException extends GeneralException {
    public UsermissionException(BaseErrorCode code) {
        super(code);
    }
}
