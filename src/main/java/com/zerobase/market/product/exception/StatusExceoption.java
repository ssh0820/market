package com.zerobase.market.product.exception;

import com.zerobase.market.common.exception.commonException;
import org.springframework.http.HttpStatus;

public class StatusExceoption extends commonException {

    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }

    @Override
    public String getMessage() {
        return "판매 종료된 상품입니다..";
    }
}
