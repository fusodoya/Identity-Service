package com.fusodoya_spring_boot.identity_service.exception;

public class AppException extends RuntimeException {
    ErrorCode errorCode;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public AppException(String message) {
        super(message);
    }
    public AppException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        setErrorCode(errorCode);
    }
}
