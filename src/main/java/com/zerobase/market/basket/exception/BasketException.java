package com.zerobase.market.basket.exception;

import com.zerobase.market.common.exception.commonException;
import org.springframework.http.HttpStatus;

public class BasketException extends commonException {

    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }

    @Override
    public String getMessage() {
        return "장바구니에 이미 등록된 상품입니다.";
    }
}
