package com.md.hw2.service.exception;

import com.md.hw2.base.exception.BaseErrorMessage;

public enum ProductErrorMessage implements BaseErrorMessage {

    PRODUCT_NOT_FOUND("Product not found!");

    private String message;

    ProductErrorMessage(String message) {
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
