package com.irv.userservice.web.model;

import lombok.Builder;

@Builder
public class ErrorInfo {
    private String url;
    private String message;
}
