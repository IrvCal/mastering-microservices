package com.irv.restaurantservice.web.model;

import com.irv.restaurantservice.domain.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantDto {
    @Null
    private String id;
    private List<Table> tables;
    @NotBlank
    @Size(min = 3)
    private String name;
    @NotBlank
    @Size(min = 5, max = 30)
    private String address;
}
