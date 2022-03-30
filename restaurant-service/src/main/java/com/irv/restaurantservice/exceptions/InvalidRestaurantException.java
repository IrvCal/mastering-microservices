package com.irv.restaurantservice.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidRestaurantException extends Exception{
    private String message;
    private Object[] args;

    public InvalidRestaurantException(String arg) {
        this.message = String.format("%s is an invalid restaurant.", arg);
    }

    public InvalidRestaurantException(Object[] args) {
        this.args = args;
    }

    public InvalidRestaurantException(String message, Object[] args) {
        this.message = message;
        this.args = args;
    }
}
