package com.irv.bookingservice.exceptions;

public class BookingNotFoundException extends Exception{
    public BookingNotFoundException() {
        super("No se encontro esta reservacion");
    }
}
