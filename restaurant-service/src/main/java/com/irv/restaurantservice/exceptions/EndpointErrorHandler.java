package com.irv.restaurantservice.exceptions;

import com.irv.restaurantservice.web.model.ErrorInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@ControllerAdvice
@RequiredArgsConstructor
public class EndpointErrorHandler extends ResponseEntityExceptionHandler {
    private static final String UNEXPECTED_ERROR = "Exception.unexpected";

    @ExceptionHandler(RestaurantNotFoundException.class)
    public ResponseEntity<ErrorInfoDto> handleRestaurantNotFoundException(HttpServletRequest request, RestaurantNotFoundException exception){
        return makeResponse(request,"No se encontro el restaurante: "+exception.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateRestaurantException.class)
    public ResponseEntity<ErrorInfoDto> handleDuplicateRestaurantException(HttpServletRequest request, DuplicateRestaurantException exception){
        return makeResponse(request,"Ya existe este resstaurante: "+exception.getMessage(),HttpStatus.IM_USED);
    }

    @ExceptionHandler(InvalidRestaurantException.class)
    public ResponseEntity<ErrorInfoDto> handleInvalidRestaurantException(HttpServletRequest request, InvalidRestaurantException exception){
        return makeResponse(request,"Restaurante no valido: "+exception.getMessage(),HttpStatus.NOT_ACCEPTABLE);
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
                .build(), HttpStatus.BAD_REQUEST);
    }
    private ResponseEntity<ErrorInfoDto> makeResponse(HttpServletRequest request, String message, HttpStatus status){
        return new ResponseEntity<>(
                ErrorInfoDto.builder()
                .url(request.getRequestURL().toString())
                .message(message)
                .build(), status);
    }

}
