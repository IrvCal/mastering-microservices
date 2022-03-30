package com.irv.userservice.web.model;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public class ErrorInfoDto {
    private String url;
    private String message;
    private HttpStatus status;
}
