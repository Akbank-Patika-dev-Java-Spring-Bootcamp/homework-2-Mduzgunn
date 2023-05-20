package com.md.hw2.service.exception;

import com.md.hw2.base.exception.BaseErrorMessage;

public enum CommentErrorMessage implements BaseErrorMessage {

    CUSTOMER_NOT_FOUND("Comment not found!");

    private String message;

    CommentErrorMessage(String message) {
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
