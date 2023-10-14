package com.zerobase.market.product.exception;

import com.zerobase.market.common.exception.commonException;
import org.springframework.http.HttpStatus;

public class ProductException extends commonException {

    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }

    @Override
    public String getMessage() {
        return "이미 사용중인 상품입니다.";
    }
}
