package com.group3.issizsiniz.exception;

public class InvalidApplyException extends RuntimeException {

    public InvalidApplyException(String message) {
        super("Already applied before");
    }
}
