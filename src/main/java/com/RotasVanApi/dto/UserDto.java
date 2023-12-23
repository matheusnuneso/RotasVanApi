package com.RotasVanApi.dto;

import com.RotasVanApi.enums.RoleUser;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String ruaEndereco;

    @NotNull
    private Integer numEndereco;

    @NotBlank
    private String bairroEndereco;

    @NotNull
    private RoleUser role;

    @NotBlank
    private String email;

}
