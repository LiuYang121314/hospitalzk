package com.litbo.hospitalzj.supplier.service.exception;

public class FindIsNullException extends ServiceException {
    public FindIsNullException() {
        super();
    }

    public FindIsNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public FindIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public FindIsNullException(String message) {
        super(message);
    }

    public FindIsNullException(Throwable cause) {
        super(cause);
    }
}
