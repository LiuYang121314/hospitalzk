package com.litbo.hospitalzj.supplier.controller.ex;

public class FileDownLoadException extends RequestException {
    public FileDownLoadException() {
        super();
    }

    public FileDownLoadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public FileDownLoadException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileDownLoadException(String message) {
        super(message);
    }

    public FileDownLoadException(Throwable cause) {
        super(cause);
    }
}
