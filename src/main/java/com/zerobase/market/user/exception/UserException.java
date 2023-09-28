package com.zerobase.market.user.exception;

import com.zerobase.market.common.exception.commonException;
import org.springframework.http.HttpStatus;

public class UserException extends commonException {

    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }

    @Override
    public String getMessage() {
        return "이미 존재하는 사용자입니다.";
    }
}
