package com.irv.restaurantservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TableDto {
    BigInteger id;
    String name;
    private int capacity;
    private boolean isModified;
}
