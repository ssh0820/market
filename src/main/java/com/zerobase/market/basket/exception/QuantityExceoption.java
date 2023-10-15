package com.zerobase.market.basket.exception;

import com.zerobase.market.common.exception.commonException;
import org.springframework.http.HttpStatus;

public class QuantityExceoption extends commonException {

    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }

    @Override
    public String getMessage() {
        return "재고보다 수량이 많습니다.";
    }
}

