package com.irv.restaurantservice.web.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorInfoDto {
    private String url;
    private String message;
}
