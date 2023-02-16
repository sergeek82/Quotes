package com.kameloon.test.task.quotes.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler({
            MethodArgumentNotValidException.class,
            EntityNotFoundException.class,
            IllegalArgumentException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorEntity handleBadRequests(Exception e, HttpServletRequest request) {
        log.error(e.getMessage());
        return getError(e, HttpStatus.BAD_REQUEST, request);
    }

    private ErrorEntity getError(Exception exception, HttpStatus status, HttpServletRequest request) {
        return ErrorEntity.builder()
                .message(exception.getMessage())
                .method(request.getMethod())
                .path(request.getRequestURL().toString())
                .status(status.value())
                .reason(status.getReasonPhrase())
                .build();
    }
}
