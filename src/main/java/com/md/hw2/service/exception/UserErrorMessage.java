package com.md.hw2.service.exception;

import com.md.hw2.base.exception.BaseErrorMessage;

public enum UserErrorMessage implements BaseErrorMessage {

    USER_NOT_FOUND("User not found!");

    private String message;

    UserErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
