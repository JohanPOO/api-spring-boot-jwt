package com.api.exceptions;

import org.springframework.http.HttpStatus;

public class ErrorResponse <T>{

    private HttpStatus http;
    private String message;
    private T errors;

    public ErrorResponse() {
    }

    public ErrorResponse(HttpStatus http, String message, T errors) {
        this.http = http;
        this.message = message;
        this.errors = errors;
    }

    public HttpStatus getHttp() {
        return http;
    }

    public void setHttp(HttpStatus http) {
        this.http = http;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getErrors() {
        return errors;
    }

    public void setErrors(T errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "http=" + http +
                ", message='" + message + '\'' +
                ", errors=" + errors +
                '}';
    }
}
