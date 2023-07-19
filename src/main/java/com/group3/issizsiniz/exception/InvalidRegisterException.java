package com.group3.issizsiniz.exception;

public class InvalidRegisterException extends RuntimeException{

    public InvalidRegisterException(String message) {
        super("Invalid Register Inputs");
    }
}
