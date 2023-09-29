package com.zerobase.market.category.exception;

import com.zerobase.market.common.exception.commonException;
import org.springframework.http.HttpStatus;

public class CategoryException extends commonException {

    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }

    @Override
    public String getMessage() {
        return "이미 사용중인 카테고리입니다.";
    }
}
