package com.irv.bookingservice.exceptions;

public class InvalidBookingException extends Exception{
    public InvalidBookingException() {
        super("Reservacion no valida");
    }
}
