package com.RotasVanApi.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Table(name = "TB_GEREN_PRESEN")
@Entity
@Data
public class GerenPresenModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private Long idAluno;

    @Column(nullable = false)
    private String dataNPresenca;

}
