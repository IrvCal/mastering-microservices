package com.irv.restaurantservice.exceptions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
@Getter
@Setter
public class DuplicateRestaurantException extends Exception{
    private static final long serialVersionUID = -8890080495441147845L;

    private String message;
    private Object[] args;

    public DuplicateRestaurantException(String name) {
        this.message = String.format("There is already a restaurant with the name - %s", name);
    }

    public DuplicateRestaurantException(String message, Object[] args) {
        this.message = message;
        this.args = args;
    }

}
