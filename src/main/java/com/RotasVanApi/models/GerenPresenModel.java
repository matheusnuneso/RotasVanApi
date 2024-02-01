package com.RotasVanApi.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Table(name = "TB_GEREN_PRESEN")
@Entity
@Data
public class GerenPresenModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private Long idAluno;

    @Column(name = "data_n_presenca", nullable = false)
    private LocalDate dataNPresenca;

}
