package com.example.firstApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleException {
    //Xử lí badrequest
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleBadRequestException(BadRequestException exception){
        return new ErrorMessage(HttpStatus.BAD_REQUEST,exception.getMessage());
    }
    //Xử lí notfound
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleBadRequestException(NotFoundException exception){
        return new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
    }
    //Xử lí các cái còn lại
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage HandleOtherException(Exception exception){
        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
    }
}
