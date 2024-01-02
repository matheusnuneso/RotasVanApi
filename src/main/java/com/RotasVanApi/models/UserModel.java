package com.RotasVanApi.models;

import com.RotasVanApi.enums.RoleUser;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Table(name = "TB_USER")
@Entity
@SequenceGenerator(name = "seq", initialValue = 10)
@Data
public class UserModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String ruaEndereco;

    @Column(nullable = false)
    private Integer numEndereco;

    @Column(nullable = false)
    private String bairroEndereco;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;
}
