package com.company.demo.controllers;

import com.company.demo.models.responses.ErrorResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * AllExceptionsHandler controller handles all exceptions
 */
@ControllerAdvice
public class AllExceptionsHandler extends ResponseEntityExceptionHandler {

    /**
     * Handles all Exceptions
     *
     * @param e       Exception
     * @param request Request
     * @return Response with code and message
     */
    @ExceptionHandler({Exception.class})
    protected ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest request) {

        ErrorResource error = new ErrorResource("InvalidRequest", e.getMessage());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return handleExceptionInternal(e, error, headers, HttpStatus.UNPROCESSABLE_ENTITY, request);
    }
}
