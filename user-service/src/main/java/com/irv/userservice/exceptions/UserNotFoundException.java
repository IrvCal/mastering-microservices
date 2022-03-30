package com.irv.userservice.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("El usuario no existe");
    }
}
