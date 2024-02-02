package com.RotasVanApi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VanDto {

    @NotBlank
    private String nomeProprietario;

    @NotBlank
    private String nomeInstituicao;

}
