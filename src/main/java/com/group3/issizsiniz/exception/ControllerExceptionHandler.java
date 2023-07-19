package com.group3.issizsiniz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseBody
    @ResponseStatus(value = HttpStatus.PRECONDITION_FAILED)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DefaultExceptionMessage> constraintViolationException(MethodArgumentNotValidException e) {
        DefaultExceptionMessage dex = new DefaultExceptionMessage();
        dex.setCode(HttpStatus.PRECONDITION_FAILED.value());
        dex.setMessage(e.getFieldErrors().get(0).getDefaultMessage());
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(dex);
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.PRECONDITION_FAILED)
    @ExceptionHandler(LoginFailedException.class)
    public ResponseEntity<DefaultExceptionMessage> loginException(LoginFailedException e) {
        DefaultExceptionMessage dex = new DefaultExceptionMessage();
        dex.setCode(HttpStatus.PRECONDITION_FAILED.value());
        dex.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(dex);
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.PRECONDITION_FAILED)
    @ExceptionHandler(InvalidRegisterException.class)
    public ResponseEntity<DefaultExceptionMessage> registerException(InvalidRegisterException e) {
        DefaultExceptionMessage dex = new DefaultExceptionMessage();
        dex.setCode(HttpStatus.PRECONDITION_FAILED.value());
        dex.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(dex);
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.PRECONDITION_FAILED)
    @ExceptionHandler(InvalidApplyException.class)
    public ResponseEntity<DefaultExceptionMessage> registerException(InvalidApplyException e) {
        DefaultExceptionMessage dex = new DefaultExceptionMessage();
        dex.setCode(HttpStatus.PRECONDITION_FAILED.value());
        dex.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(dex);
    }



}