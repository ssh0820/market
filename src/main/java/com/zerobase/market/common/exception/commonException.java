package com.zerobase.market.common.exception;

public abstract class commonException extends RuntimeException{

    abstract public int getStatusCode();
    abstract public String getMessage();
}
