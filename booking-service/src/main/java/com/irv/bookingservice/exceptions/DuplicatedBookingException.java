package com.irv.bookingservice.exceptions;

public class DuplicatedBookingException extends Exception{
    public DuplicatedBookingException(String message) {
        super("Esta reservacion ya existe");
    }
}
