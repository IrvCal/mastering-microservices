package com.irv.userservice.exceptions;

import com.irv.userservice.web.model.ErrorInfoDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorInfoDto> handleUserNotFoundException(HttpServletRequest request, UserNotFoundException exception){
        return makeResponse(request,exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfoDto> handleException(HttpServletRequest request, Exception exception){
        return makeResponse(request,"PROBLEMAS "+exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(ErrorInfoDto.builder()
                .url(request.getDescription(false))
                .message(ex.getBindingResult().toString())
                .status(HttpStatus.NOT_ACCEPTABLE)
                .build(), HttpStatus.BAD_REQUEST);
    }
    private ResponseEntity<ErrorInfoDto> makeResponse(HttpServletRequest request, String message, HttpStatus status){
        return new ResponseEntity<>(
                ErrorInfoDto.builder()
                        .url(request.getRequestURL().toString())
                        .message(message)
                        .status(status)
                        .build(), status);
    }

}
