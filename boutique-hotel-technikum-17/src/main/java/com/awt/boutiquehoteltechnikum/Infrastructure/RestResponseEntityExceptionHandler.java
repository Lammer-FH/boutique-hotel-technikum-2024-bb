package com.awt.boutiquehoteltechnikum.Infrastructure;

import com.awt.boutiquehoteltechnikum.DTO.ErrorDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.NoSuchElementException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Conflict";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = { IllegalArgumentException.class })
    protected ResponseEntity<Object> handleIllegalArgumentException(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "This should be application specific";
        ErrorDTO errorDTO = new ErrorDTO(
                bodyOfResponse,
                404,
                ex.getMessage(),
                ((ServletWebRequest)request).getRequest().getRequestURI().toString()
        );
        return handleExceptionInternal(ex, errorDTO,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
    @ExceptionHandler(value = { NoSuchElementException.class })
    protected ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex, ServletWebRequest request) {
        String bodyOfResponse = "One of the provided Ids could not be found";
        ErrorDTO errorDTO = new ErrorDTO(
                bodyOfResponse,
                404,
                ex.getMessage(),
                request.getRequest().getRequestURI().toString()
        );
        return handleExceptionInternal(ex, errorDTO,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
