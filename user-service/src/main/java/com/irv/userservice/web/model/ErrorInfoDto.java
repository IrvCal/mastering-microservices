package com.irv.userservice.web.model;

import lombok.*;
import org.springframework.http.HttpStatus;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorInfoDto {
    private String url;
    private String message;
    private HttpStatus status;
}
