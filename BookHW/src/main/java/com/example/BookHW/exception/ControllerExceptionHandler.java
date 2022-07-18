package com.example.BookHW.exception;

import com.example.BookHW.model.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResponse globalExceptionHandler(Exception ex, WebRequest request) {
        CommonResponse response = new CommonResponse();
        response.setData(HttpStatus.INTERNAL_SERVER_ERROR.value() + " " +  ex.getMessage() + " " + request.getDescription(false));
        return response;
    }
}