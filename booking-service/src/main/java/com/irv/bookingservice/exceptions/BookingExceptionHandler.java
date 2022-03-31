package com.irv.bookingservice.exceptions;

import com.irv.bookingservice.web.model.ErrorInfoDto;
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
public class BookingExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<ErrorInfoDto> handleBookingNotFoundException(HttpServletRequest request, BookingNotFoundException exception){
        return makeResponse(request,exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicatedBookingException.class)
    public ResponseEntity<ErrorInfoDto> handleDuplicatedBooking(HttpServletRequest request, DuplicatedBookingException exception){
        return makeResponse(request,exception.getMessage(), HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(InvalidBookingException.class)
    public ResponseEntity<ErrorInfoDto> handleInvalidBookingException(HttpServletRequest request, InvalidBookingException exception){
        return makeResponse(request,exception.getMessage(), HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(ListBookingsNotFoundException.class)
    public ResponseEntity<ErrorInfoDto> handleListBookingsNotFoundException(HttpServletRequest request, ListBookingsNotFoundException exception){
        return makeResponse(request,exception.getMessage(), HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfoDto> handleException(HttpServletRequest request, Exception exception){
        return makeResponse(request,"PROBLEMAS "+exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(ErrorInfoDto.builder()
                .url(request.getDescription(false))
                .message(ex.getBindingResult().toString())
                .status(HttpStatus.NOT_ACCEPTABLE)
                .build(), HttpStatus.NOT_ACCEPTABLE);
    }

    private ResponseEntity<ErrorInfoDto> makeResponse(HttpServletRequest request, String message, HttpStatus status){
        return new ResponseEntity<>(
                ErrorInfoDto.builder()
                        .url(request.getRequestURL().toString())
                        .message(message)
                        .status(status)
                        .build(),
                status);
    }
}
