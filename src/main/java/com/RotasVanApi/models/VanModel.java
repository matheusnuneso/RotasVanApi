package com.RotasVanApi.models;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "TB_VAN")
@Entity
@SequenceGenerator(name = "seq1", initialValue = 2)
@Data
public class VanModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")
    private Long id;

    @Column(nullable = false)
    private String nomeProprietario;

    @Column(nullable = false)
    private String nomeInstituicao;

}
