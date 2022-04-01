package com.irv.restaurantservice.web.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
public class ErrorInfoDto {
    private String url;
    private String message;
    private HttpStatus status;
}
