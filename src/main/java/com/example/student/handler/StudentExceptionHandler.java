package com.example.student.handler;

import lombok.Data;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ErrorDto handleException(Exception exception) {
        return new ErrorDto(exception.getMessage(), 404);

    }

    @Data
    private static class ErrorDto {
        private final String message;
        private final int code;
    }

}
