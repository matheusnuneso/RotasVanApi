package com.RotasVanApi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthUserDto {

    @NotBlank
    private String email;

    @NotBlank
    private String senha;
}
