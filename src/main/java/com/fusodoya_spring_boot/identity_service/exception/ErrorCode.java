package com.fusodoya_spring_boot.identity_service.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(1000, "Uncategorized Exception!"),
    USER_EXISTED(1001, "User existed!"),
    USER_NOT_FOUND(1002, "User Not Found!"),
    INVALID_USERNAME(1003, "Username need be at least 4 characters!"),
    INVALID_PASSWORD(1004, "Password need be at least 8 characters!"),
    INVALID_KEY(1005, "Invalid Key!"),
    ;

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
