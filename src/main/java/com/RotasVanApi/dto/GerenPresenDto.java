package com.RotasVanApi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class GerenPresenDto {

    @NotNull
    private Long idAluno;

    @NotNull
    private String dataNPresenca;

}
