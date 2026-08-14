package com.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse<?> manejarValidacion(MethodArgumentNotValidException ex){

        ErrorResponse<Map<Object, Object>> errorResponse = new ErrorResponse<>();
        Map<Object, Object> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        errorResponse.setHttp(HttpStatus.BAD_REQUEST);
        errorResponse.setMessage("Error en los datos");
        errorResponse.setErrors(errors);

        return errorResponse;
    }

    @ExceptionHandler(NullPointerExceptionError.class)
    public ErrorResponse<?> nullPointerException(NullPointerExceptionError ex) {

        ErrorResponse<String> errorResponse = new ErrorResponse<>();
        errorResponse.setHttp(HttpStatus.NOT_FOUND);
        errorResponse.setMessage("Null attribute");
        errorResponse.setErrors(ex.getMessage());

        return errorResponse;
    }

}
