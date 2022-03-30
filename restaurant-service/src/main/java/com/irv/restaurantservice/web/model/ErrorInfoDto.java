package com.irv.restaurantservice.web.model;

import lombok.Builder;

@Builder
public class ErrorInfoDto {
    private String url;
    private String message;
}
