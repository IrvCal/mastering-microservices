package com.irv.bookingservice.exceptions;

public class ListBookingsNotFoundException extends Exception{
    public ListBookingsNotFoundException() {
        super("No hay reservaciones con este nombre");
    }
}
