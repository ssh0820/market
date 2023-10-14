package com.zerobase.market.user.exception;

import com.zerobase.market.common.exception.commonException;
import org.springframework.http.HttpStatus;

public class AuthException extends commonException {
    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }

    @Override
    public String getMessage() {
        return "해당 사용자의 권한을 확인해주세요.";
    }
}
