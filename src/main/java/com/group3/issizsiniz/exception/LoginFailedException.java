package com.group3.issizsiniz.exception;

public class LoginFailedException extends RuntimeException {


    public LoginFailedException(String message) {
        super("Invalid mail or password");
    }
}
