package com.irv.userservice.web.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Builder
@Setter
@Getter
public class ErrorInfoDto {
    private String url;
    private String message;
    private HttpStatus status;
}
