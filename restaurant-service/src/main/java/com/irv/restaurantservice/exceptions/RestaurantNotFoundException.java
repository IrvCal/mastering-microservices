package com.irv.restaurantservice.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantNotFoundException extends Exception{
    private String message ="NO SE ENCONTRO ESTE RESTAURANTE";
    private Object[] args;

    public RestaurantNotFoundException(String message) {
        this.message = message;
    }
    public RestaurantNotFoundException(Object[] args) {
        this.args = args;
    }
    public RestaurantNotFoundException(String message, Object[] args){
        this.message = message;
        this.args = args;
    }

    public RestaurantNotFoundException() {
    }
}
