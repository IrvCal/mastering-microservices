package com.irv.userservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @Null
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String last_name;
    @NotBlank
    @Positive
    @Size(min = 10,max = 10)
    private Long phone;
}
